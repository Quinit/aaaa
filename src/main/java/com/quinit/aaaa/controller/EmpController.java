package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.EmpQueryParam;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.sevice.EmpService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

//    String name,
//    String gender,
//    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
//    @RequestParam(defaultValue = "1") Integer page,
//    @RequestParam(defaultValue = "10") Integer pageSize
    @GetMapping
    public Result getEmp(EmpQueryParam empQueryParam){
        log.info("分页查询");
        PageResult<Emp> pageResult = empService.getEmps(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("添加员工");
        try {
            empService.addEmp(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.success();
    }

    @DeleteMapping
    public Result deleteEmp(@RequestParam List<Integer> ids){
        log.info("删除员工:{}", ids);
        empService.deleteEmp(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getEmpInfoById(@PathVariable Integer id){
        log.info("查询员工:{}", id);
        Emp emp = empService.getEmpInfoById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmpInfo(@RequestBody Emp emp){
        log.info("更新员工:{}", emp);
        empService.updateEmpInfo(emp);
        return Result.success();
    }
}
