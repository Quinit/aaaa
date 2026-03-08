package com.quinit.aaaa.exception;

import com.quinit.aaaa.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        log.error("捕获到异常:{}",e);
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    @ExceptionHandler
    public Result DuplicateKeyException(DuplicateKeyException e){
        log.error("捕获到异常:{}",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        return Result.error(errMsg.split(" ")[2] + "已存在");
    }

    @ExceptionHandler
    public Result DeptNotEmptyException(DeptNotEmptyException e){
        log.error("捕获到异常:{}",e);
        return Result.error("部门下有员工，不能删除");
    }

    @ExceptionHandler
    public Result LoginException(LoginException e){
        log.error("捕获到异常:{}",e);
        return Result.error("用户名或密码错误");
    }

}