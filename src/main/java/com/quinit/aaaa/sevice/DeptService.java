package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门
     * @return null
     */
    List<Dept> findAll();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept getDept(Integer id);

    void updateDept(Dept dept);
}
