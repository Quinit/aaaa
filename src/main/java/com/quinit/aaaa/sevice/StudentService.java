package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Student;
import com.quinit.aaaa.pojo.queryparam.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> getStudentList(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student getStudentInfoById(Integer id);

    void updateStudent(Student student);

    void deleteStudentByIds(List<Integer> ids);

    void updateStudentViolationInfo(Integer id, Integer score);
}
