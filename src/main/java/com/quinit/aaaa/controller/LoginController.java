package com.quinit.aaaa.controller;

import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.LoginInfo;
import com.quinit.aaaa.pojo.Result;
import com.quinit.aaaa.sevice.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("用户{}登录", emp.getUsername());
        LoginInfo loginInfo = loginService.login(emp);
        return Result.success(loginInfo);
    }
}
