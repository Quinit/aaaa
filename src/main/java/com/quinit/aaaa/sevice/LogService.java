package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.OperateLog;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.queryparam.LogQueryParam;

public interface LogService {
    PageResult<OperateLog> getLogPage(LogQueryParam logQueryParam);
}
