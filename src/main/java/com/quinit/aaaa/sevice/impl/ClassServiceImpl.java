package com.quinit.aaaa.sevice.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.quinit.aaaa.mapper.ClassMapper;
import com.quinit.aaaa.pojo.queryparam.ClassQueryParam;
import com.quinit.aaaa.pojo.Clazz;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.sevice.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public PageResult<Clazz> getClassList(ClassQueryParam classQueryParam) {
        classQueryParam.setNow(LocalDate.now());
        PageHelper.startPage(classQueryParam.getPage(), classQueryParam.getPageSize());
        List<Clazz> rows = classMapper.getClassList(classQueryParam);
        Page<Clazz> p = (Page<Clazz>) rows;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteClass(Integer id) {
        classMapper.deleteClass(id);
    }

    @Override
    public void addClass(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        classMapper.addClass(clazz);
    }

    @Override
    public List<Clazz> getALLClassInfo() {
        return classMapper.getALLClassInfo();
    }

    @Override
    public void upDateClass(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        classMapper.upDateClass(clazz);
    }

    @Override
    public Clazz getClassById(Integer id) {
        return classMapper.getClassById(id);
    }
}
