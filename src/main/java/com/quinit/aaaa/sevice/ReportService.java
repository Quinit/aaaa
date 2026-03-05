package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobReport();

    List<Map<String, Object>> getEmpGenderData();
}
