package com.quinit.aaaa.filter;

import com.quinit.aaaa.utils.JwtsOperator;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter("/*")
@Slf4j
public class LoginFilter implements Filter {

    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("init 初始化中...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Filter 拦截中...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();//请求路径 /login
        if(requestURI.contains("/login")){
            log.info("用户登录中...");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("无令牌");
            //401状态码
            response.setStatus(401);
            return;
        }

        //解析JWT
        try{
            JwtsOperator.parseToken(token);
        }
        catch (Exception e){
            //令牌非法
            log.info("令牌非法");
            //返回状态码401
            response.setStatus(401);
            return;
        }

        log.info("用户已登录");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("destroy 销毁中...");
    }
}
