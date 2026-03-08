package com.quinit.aaaa.sevice.impl;

import com.quinit.aaaa.mapper.EmpMapper;
import com.quinit.aaaa.mapper.StudentMapper;
import com.quinit.aaaa.pojo.JobOption;
import com.quinit.aaaa.pojo.StudentCount;
import com.quinit.aaaa.sevice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobReport() {
        List<Map<String,Object>> jobData = empMapper.countEmpJobData();
        List<Object> jobList =  jobData.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList =  jobData.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.getEmpGenderData();
    }

    @Override
    public StudentCount getStudentCountData() {
        List<Map<String,Object>> studentCountData = studentMapper.getStudentCountData();
        List<Object> clazzList = studentCountData.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = studentCountData.stream().map(dataMap -> dataMap.get("value")).toList();
        return new StudentCount(clazzList,dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }
}
