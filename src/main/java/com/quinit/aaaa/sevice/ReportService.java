package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.JobOption;
import com.quinit.aaaa.pojo.StudentCount;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobReport();

    List<Map<String, Object>> getEmpGenderData();

    StudentCount getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
