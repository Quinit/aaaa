package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.queryparam.ClassQueryParam;
import com.quinit.aaaa.pojo.Clazz;
import com.quinit.aaaa.pojo.PageResult;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.sevice.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public Result getClassList(ClassQueryParam classQueryParam) {
        log.info("班级列表查询");
        PageResult<Clazz> classList = classService.getClassList(classQueryParam);
        return Result.success(classList);
    }

    @DeleteMapping("/{id}")
    public Result deleteClass(@PathVariable Integer id) {
        log.info("删除班级:{}",id);
        classService.deleteClass(id);
        return Result.success();
    }

    @PostMapping
    public Result addClass(@RequestBody Clazz clazz) {
        log.info("添加班级：{}",clazz);
        classService.addClass(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClassById(@PathVariable Integer id) {
        log.info("根据id查询");
        Clazz clazz = classService.getClassById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result updateClass(@RequestBody Clazz clazz) {
        log.info("修改班级");
        classService.upDateClass(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getALLClassInfo(){
        log.info("查询所有班级信息");
        List<Clazz> allClassInfo = classService.getALLClassInfo();
        return Result.success(allClassInfo);
    }


}
