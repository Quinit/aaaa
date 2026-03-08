package com.quinit.aaaa.controller;

import com.quinit.aaaa.anno.LogOperation;
import com.quinit.aaaa.pojo.Dept;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.sevice.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")

public class DeptController {

    public static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @LogOperation
    @GetMapping
    public Result list(){
        //System.out.print("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
        //System.out.print("根据id删除部门数据");
        log.info("根据id删除部门数据");
        deptService.deleteById(id);
        return Result.success();
    }
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //System.out.print("添加部门数据" + dept);
        log.info("添加部门数据{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }
    @LogOperation
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        //System.out.print("根据id获取部门");
        log.info("根据id获取部门");
        Dept dept = deptService.getDept(id);
        return Result.success(dept);
    }
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.print("修改部门数据" + dept);
        log.info("修改部门数据{}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }
}
