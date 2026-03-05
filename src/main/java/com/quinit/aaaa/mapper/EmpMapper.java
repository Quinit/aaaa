package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by " +
//            "e.update_time desc limit #{start},#{pageSize}")
//    List<Emp> getEmps(Integer start, Integer pageSize);
//
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    Long count();

//        @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by " +
//            "e.update_time desc")

    List<Emp> getEmps(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    void deleteEmpByIds(List<Integer> ids);

    Emp getEmpsInfoById(Integer id);

    void updateEmpInfo(Emp emp);

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> getEmpGenderData();
}
