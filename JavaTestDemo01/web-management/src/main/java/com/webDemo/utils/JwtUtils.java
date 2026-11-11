package com.webDemo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/** JWT 生成与解析工具。 */
public final class JwtUtils {

    // 与 JwtTest 中的示例密钥保持一致，仅供学习和本地测试。
    private static final String SIGNING_KEY = "MTIzNDU2";
    private static final long EXPIRATION_MILLIS = 60 * 60 * 1000L;

    private JwtUtils() {
    }

    /** 根据自定义数据生成有效期为一小时的 JWT。 */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .compact();
    }

    /** 验证并解析 JWT；签名错误或令牌过期时会抛出异常。 */
    public static Claims parseJwt(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
