package com.quinit.aaaa.sevice.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.quinit.aaaa.mapper.EmpExprMapper;
import com.quinit.aaaa.mapper.EmpMapper;
import com.quinit.aaaa.pojo.*;
import com.quinit.aaaa.pojo.queryparam.EmpQueryParam;
import com.quinit.aaaa.sevice.EmpLogService;
import com.quinit.aaaa.sevice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> getEmps(EmpQueryParam empQueryParam) {
//        Long total = empMapper.count();
//        Integer start = pageSize * (page - 1);
//        List<Emp> rows = empMapper.getEmps(start, pageSize);
//        return new PageResult<Emp>(total, rows);
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> rows = empMapper.getEmps(empQueryParam);
        Page<Emp> p = (Page<Emp>) rows;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addEmp(Emp emp) throws Exception{
        try {
            emp.setPassword("123456");
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);

            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr ->{
                    empExpr.setEmpId(empId);
                });
                empExprMapper.addEmpExpr(exprList);
            }
        } finally {
            //操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "添加员工:" + emp);
            empLogService.insertLog(empLog);
        }

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmpByIds(ids);
        empExprMapper.deleteEmpExprByEmpIds(ids);
    }

    @Override
    public Emp getEmpInfoById(Integer id) {
        return empMapper.getEmpsInfoById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateEmpInfo(Emp emp) {
        //修改基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmpInfo(emp);

        //修改工作经理，先删除后添加

        empExprMapper.deleteEmpExprByEmpIds(Collections.singletonList(emp.getId()));

        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr ->{
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.addEmpExpr(exprList);
        }


    }

    @Override
    public List<Emp> getAllEmpInfo() {
        return empMapper.getAllEmpInfo();
    }

}
