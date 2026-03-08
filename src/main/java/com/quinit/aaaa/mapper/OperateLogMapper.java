package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.OperateLog;
import com.quinit.aaaa.pojo.queryparam.LogQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public int insert(OperateLog log);

    @Select("select o.*,e.name operateEmpName from operate_log o,emp e where e.id = o.operate_emp_id")
    List<OperateLog> getLogPage(LogQueryParam logQueryParam);
}
