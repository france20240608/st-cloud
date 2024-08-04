package com.st.cloud.common.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.st.cloud.common.constants.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @author gpx
 */
public class JwtUtils
{
    static String secret = "8WyNnoF+*hS_mcQldkLkBM3s0!R9=qRrmdArXl63236KhB8-j3-wOrJb9FyN*qWK";
    static SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createToken(Map<String, Object> claims) {
        return Jwts.builder().claims(claims).signWith(key).compact();
    }

    public static void main(String[] args) {
        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<String, Object>();
        claimsMap.put(SecurityConstant.USER_KEY, UUID.fastUUID().toString());
        claimsMap.put(SecurityConstant.DETAILS_USER_ID, "1");
        claimsMap.put(SecurityConstant.DETAILS_USERNAME, "admin");
        claimsMap.put(SecurityConstant.DETAILS_USER_IP, "192.111.111.111");
        String token = createToken(claimsMap);

        System.out.println(token);
        System.out.println(getUserKey(token));
        System.out.println(getUserId(token));
        System.out.println(getUserName(token));
        System.out.println(getUserIp(token));
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    /**
     * 根据令牌获取用户标识
     * 
     * @param token 令牌
     * @return 用户ID
     */
    public static String getUserKey(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstant.USER_KEY);
    }

    /**
     * 根据令牌获取用户标识
     * 
     * @param claims 身份信息
     * @return 用户ID
     */
    public static String getUserKey(Claims claims) {
        return getValue(claims, SecurityConstant.USER_KEY);
    }

    /**
     * 根据令牌获取用户ID
     * 
     * @param token 令牌
     * @return 用户ID
     */
    public static String getUserId(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstant.DETAILS_USER_ID);
    }

    /**
     * 根据身份信息获取用户ID
     * 
     * @param claims 身份信息
     * @return 用户ID
     */
    public static String getUserId(Claims claims) {
        return getValue(claims, SecurityConstant.DETAILS_USER_ID);
    }

    /**
     * 根据令牌获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUserName(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstant.DETAILS_USERNAME);
    }

    /**
     * 根据令牌获取用户登录IP
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUserIp(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstant.DETAILS_USER_IP);
    }

    /**
     * 根据身份信息获取用户名
     * 
     * @param claims 身份信息
     * @return 用户名
     */
    public static String getUserName(Claims claims) {
        return getValue(claims, SecurityConstant.DETAILS_USERNAME);
    }

    /**
     * 根据身份信息获取键值
     * 
     * @param claims 身份信息
     * @param key 键
     * @return 值
     */
    public static String getValue(Claims claims, String key){
        Object value = claims.get(key);
        if (ObjectUtil.isNull(value)){
            return "";
        }
        if (value instanceof String){
            return (String) value;
        }
        return value.toString();
    }
}
