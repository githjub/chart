package com.example.springboot.util;

import io.jsonwebtoken.*;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/30 15:16
 * JWT工具类
 */
public class JWTUtil {
    /**
     * 签发JWT
     *
     * @param id
     * @param subject   可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return String
     *
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder().setId(id).setSubject(subject) // 主题
                .setIssuer("user") // 签发者
                .setIssuedAt(now) // 签发时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static JsonResultBean validateJWT(String jwtStr) {
        JsonResultBean jsonResultBean = new JsonResultBean();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            jsonResultBean.setCode(0);
            jsonResultBean.setMsg("JWT验证成功");
            jsonResultBean.setData(claims);
        } catch (ExpiredJwtException e) {
            jsonResultBean.setData(SystemConstant.JWT_ERRCODE_EXPIRE);
            jsonResultBean.setMsg("JWT验证失败1");
            jsonResultBean.setCode(1);
        } catch (SignatureException e) {
            jsonResultBean.setData(SystemConstant.JWT_ERRCODE_FAIL);
            jsonResultBean.setMsg("JWT验证失败2");
            jsonResultBean.setCode(1);
        } catch (Exception e) {
            jsonResultBean.setData(SystemConstant.JWT_ERRCODE_FAIL);
            jsonResultBean.setMsg("JWT验证失败3");
            jsonResultBean.setCode(1);
        }
        return jsonResultBean;
    }

    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     *
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
    }
}