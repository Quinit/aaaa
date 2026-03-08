package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.queryparam.EmpQueryParam;
import com.quinit.aaaa.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> getEmps(EmpQueryParam empQueryParam);

    void addEmp(Emp emp) throws Exception;

    void deleteEmp(List<Integer> ids);

    Emp getEmpInfoById(Integer id);

    void updateEmpInfo(Emp emp);

    List<Emp> getAllEmpInfo();
}
