package com.quinit.aaaa.sevice.impl;

import com.quinit.aaaa.exception.LoginException;
import com.quinit.aaaa.mapper.LoginMapper;
import com.quinit.aaaa.pojo.Emp;
import com.quinit.aaaa.pojo.LoginInfo;
import com.quinit.aaaa.sevice.LoginService;
import com.quinit.aaaa.utils.JwtsOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public LoginInfo login(Emp emp) {
        LoginInfo loginInfo = loginMapper.login(emp);
        if (loginInfo == null){
            throw new LoginException("用户名或密码错误");
        }else{
            log.info("用户{}登录成功", loginInfo.getUsername());
            //JWT
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginInfo.getId());
            claims.put("username", loginInfo.getUsername());
            String token =JwtsOperator.generateToken(claims);
            loginInfo.setToken(token);

            return loginInfo;
        }
    }
}
