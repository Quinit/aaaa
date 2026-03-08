package com.quinit.aaaa;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testJWT(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("username","admin");
        claims.put("password","123456");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "UXVpbnQ=")
                .addClaims(claims)
                .setExpiration(new Date())
                .compact();
        System.out.println(jwt);

    }


    @Test
    public void testParseJWT(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE3NzI3ODk2OTd9.r2R7SWYq-W7ivv4A9nsYFryQH_N-_WbOCBeCNrp_dA0";
        String jwtParse = String.valueOf(Jwts.parser()
                .setSigningKey("UXVpbnQ=")
                .parseClaimsJws(jwt)
                .getBody());
        System.out.println(jwtParse);
    }
}
