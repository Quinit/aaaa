package com.quinit.aaaa.sevice.impl;

import com.quinit.aaaa.exception.DeptNotEmptyException;
import com.quinit.aaaa.mapper.DeptMapper;
import com.quinit.aaaa.mapper.EmpMapper;
import com.quinit.aaaa.pojo.Dept;
import com.quinit.aaaa.sevice.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) throws DeptNotEmptyException {
        if(empMapper.deptEmpCount(id)==0){
            deptMapper.deleteById(id);
        }
        else{
            throw new DeptNotEmptyException("部门下有员工，不能删除");
        };
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept getDept(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }


}
