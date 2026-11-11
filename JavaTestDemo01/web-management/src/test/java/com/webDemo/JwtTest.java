package com.webDemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;


public class JwtTest {

    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new java.util.HashMap<>();
        dataMap.put("username", "admin");
        dataMap.put("role", "admin");
      String token =  Jwts.builder()
              .signWith(SignatureAlgorithm.HS256,"MTIzNDU2")
              .addClaims(dataMap)
              .setExpiration(new Date(System.currentTimeMillis()+ 3600*1000))
              .compact();
        System.out.println(token);
    }

    @Test
    public void testParseJwt(){
      String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzk0Mzg0NzE4fQ.K5PF7BMu7rY2YK1N4asEYcRKQvuitUhOLWKufI7eRNk";
      Claims claims = Jwts.parser().setSigningKey("MTIzNDU2").parseClaimsJws(token).getBody();
      System.out.println(claims);

    }


}
