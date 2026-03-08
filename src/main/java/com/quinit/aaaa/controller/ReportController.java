package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.JobOption;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.pojo.StudentCount;
import com.quinit.aaaa.sevice.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    private Result getEmpJobData() {
        log.info("员工职位人数");
        JobOption jobOption = reportService.getEmpJobReport();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    private Result getEmpGenderData(){
        log.info("员工性别统计");
        List<Map<String,Object>> empGenderData = reportService.getEmpGenderData();
        log.info("员工性别统计{}",empGenderData);
        return Result.success(empGenderData);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<Map<String,Object>> studentDegreeData = reportService.getStudentDegreeData();
        return Result.success(studentDegreeData);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        StudentCount studentCount = reportService.getStudentCountData();
        return Result.success(studentCount);
    }
}
