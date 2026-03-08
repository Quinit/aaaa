package com.quinit.aaaa.sevice.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.quinit.aaaa.mapper.StudentMapper;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Student;
import com.quinit.aaaa.pojo.queryparam.StudentQueryParam;
import com.quinit.aaaa.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public PageResult<Student> getStudentList(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> rows = studentMapper.getStudentList(studentQueryParam);
        Page<Student> p = (Page<Student>) rows;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void addStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    @Override
    public Student getStudentInfoById(Integer id) {
        return studentMapper.getStudentInfoById(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudentByIds(List<Integer> ids) {
        studentMapper.deleteStudentByIds(ids);
    }

    @Override
    public void updateStudentViolationInfo(Integer id, Integer score) {
        LocalDateTime updateTime = LocalDateTime.now();
        studentMapper.updateStudentViolationInfo(id, score, updateTime);
    }
}
