package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select id,username,name from emp where username = #{username} and password = #{password}")
    LoginInfo login(Emp emp);
}
