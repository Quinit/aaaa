package com.quinit.aaaa.sevice.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.quinit.aaaa.mapper.OperateLogMapper;
import com.quinit.aaaa.pojo.OperateLog;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.queryparam.LogQueryParam;
import com.quinit.aaaa.sevice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServoceImpl implements LogService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> getLogPage(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        List<OperateLog> rows = operateLogMapper.getLogPage(logQueryParam);
        Page<OperateLog> p = (Page<OperateLog>) rows;
        return new PageResult<OperateLog>(p.getTotal(), p.getResult());

    }
}
