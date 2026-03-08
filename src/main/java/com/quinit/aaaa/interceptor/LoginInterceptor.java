package com.quinit.aaaa.interceptor;

import com.quinit.aaaa.utils.CurrentHolder;
import com.quinit.aaaa.utils.JwtsOperator;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();//请求路径 /login
        if(requestURI.contains("/login")){
            log.info("用户登录中...");
            return true;
        }

        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("无令牌");
            //401状态码
            response.setStatus(401);
            return false;
        }

        //解析JWT
        try{
            Claims claims = JwtsOperator.parseToken(token);
            Integer id = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(id);
            log.info("当前用户id为：{}", id);
        }
        catch (Exception e){
            //令牌非法
            log.info("令牌非法");
            //返回状态码401
            response.setStatus(401);
            return false;
        }

        log.info("用户已登录");
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        CurrentHolder.remove();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
