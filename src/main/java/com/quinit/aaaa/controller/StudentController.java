package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.pojo.Student;
import com.quinit.aaaa.pojo.queryparam.StudentQueryParam;
import com.quinit.aaaa.sevice.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result getStudentList(StudentQueryParam studentQueryParam){
        log.info("查询学生");
        PageResult<Student> studentList = studentService.getStudentList(studentQueryParam);
        return Result.success(studentList);
    }

    @PostMapping
    public Result addStudent(@RequestBody Student student){
        log.info("添加学生");
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getStudentInfoById(@PathVariable Integer id){
        log.info("查询学生:{}", id);
        Student student = studentService.getStudentInfoById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudentInfo(@RequestBody Student student){
        log.info("更新学生:{}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteStudentByIds(@PathVariable List<Integer> ids){
        studentService.deleteStudentByIds(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolationInfo(@PathVariable Integer id, @PathVariable Integer score){
        studentService.updateStudentViolationInfo(id, score);
        return Result.success();
    }

}
