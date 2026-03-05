package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploaderController {
//    @PostMapping("/upload")
//    public Result upload(@RequestParam("username") String name, Integer age, MultipartFile file) {
//        log.info("参数{},{},{}",name, age, file);
//        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String newFileName = UUID.randomUUID().toString() + extension;
//        try {
//            file.transferTo(new File("D:/images/" + newFileName));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return Result.success();
//    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}",file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("url");
        return Result.success(url);
    }
}
