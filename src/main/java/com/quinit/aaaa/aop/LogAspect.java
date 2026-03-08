package com.quinit.aaaa.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinit.aaaa.mapper.OperateLogMapper;
import com.quinit.aaaa.pojo.OperateLog;
import com.quinit.aaaa.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("@annotation(com.quinit.aaaa.anno.LogOperation)")
    public void logOperationPointcut() {}

    @Around("logOperationPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        
        saveLog(joinPoint, result, costTime);
        
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, Object result, long costTime) {
        try {
            Integer operateEmpId = getCurrentUserId();
            
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            
//            String methodParams = objectToJson(joinPoint.getArgs());
//
//            String returnValue = objectToJson(result);
            String methodParams = Arrays.toString(joinPoint.getArgs());

            String returnValue = result.toString();
            
            OperateLog operateLog = new OperateLog();
            operateLog.setOperateEmpId(operateEmpId);
            operateLog.setOperateTime(LocalDateTime.now());
            operateLog.setClassName(className);
            operateLog.setMethodName(methodName);
            operateLog.setMethodParams(methodParams);
            operateLog.setReturnValue(returnValue);
            operateLog.setCostTime(costTime);
            
            operateLogMapper.insert(operateLog);
            
            log.info("操作日志记录成功：{}.{} , 操作人 ID: {}, 耗时：{}ms", 
                    className, methodName, operateEmpId, costTime);
        } catch (Exception e) {
            log.error("记录操作日志失败：{}", e.getMessage(), e);
        }
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }

}
