package com.quinit.aaaa.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtsOperator {

    private static final String SECRET_KEY = "UXVpbnQ=";
    private static final long EXPIRATION_TIME = 86400000L;

    /**
     * 生成 JWT 令牌
     * @param claims 自定义声明数据
     * @return JWT 令牌字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析 JWT 令牌
     * @param jwt JWT 令牌字符串
     * @return Claims 对象
     * @throws RuntimeException 解析失败时抛出异常
     */
    public static Claims parseToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("JWT 解析失败：" + e.getMessage(), e);
        }
    }
}
