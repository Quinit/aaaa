package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.Student;
import com.quinit.aaaa.pojo.queryparam.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {


    void updateStudent(Student student);

    List<Student> getStudentList(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student getStudentInfoById(Integer id);

    void deleteStudentByIds(List<Integer> ids);

    void updateStudentViolationInfo(Integer id, Integer score, LocalDateTime updateTime);

    List<Map<String, Object>> getStudentDegreeData();

    List<Map<String, Object>> getStudentCountData();
}
