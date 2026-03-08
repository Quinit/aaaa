package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.OperateLog;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.pojo.queryparam.LogQueryParam;
import com.quinit.aaaa.sevice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;
    @GetMapping("page")
    public Result logPage(LogQueryParam logQueryParam){
        PageResult<OperateLog> logOperationPageResult = logService.getLogPage(logQueryParam);
        return Result.success(logOperationPageResult);
    }
}
