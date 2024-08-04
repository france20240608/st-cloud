package com.st.cloud.framework.security.core.service;

import cn.hutool.core.lang.UUID;
import com.st.cloud.common.constants.SecurityConstant;
import com.st.cloud.common.util.JwtUtils;
import com.st.cloud.common.core.IRedisKey;
import com.st.cloud.framework.redis.core.RedisUtil;
import com.st.cloud.framework.security.core.context.SecurityContextHolder;
import com.st.cloud.framework.security.core.entity.LoginUser;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenService {

    @Resource
    private RedisUtil redisUtil;
    public String createToken(LoginUser loginUser) {

        String cacheKeyPrefix = IRedisKey.ADMIN_LOGIN_PREFIX + TenantContextHolder.getTenantId();

        // 1.清理旧的用户登录信息
        // 1.1 根据用户名，获取旧的userKey
        String cacheKeyUserKey = cacheKeyPrefix + ":" + loginUser.getUsername();
        String oldUserKey = redisUtil.getString(cacheKeyUserKey);
        // 1.2 移除旧userKey用户信息在Redis中的缓存
        String cacheKey = cacheKeyPrefix + ":" + oldUserKey;
        redisUtil.remove(cacheKey);
        // 1.3 移除Context中的用户信息
        SecurityContextHolder.clear();

        // 2.生成新的登录信息和token，并将用户登录信息放到redis，提供给网关进行检查，用户是否还在登录态
        // 2.1 生成新的userKey
        String newUserKey = UUID.fastUUID().toString();
        cacheKey = cacheKeyPrefix + ":" + newUserKey;
        // 2.2 将新的userKey设置到redis中，会覆盖旧的
        redisUtil.set(cacheKeyUserKey, newUserKey, Duration.ofSeconds(60 * 60 * 24 * 7));
        // 2.3 将新的用户登录信息设置到redis中
        redisUtil.set(cacheKey, loginUser, Duration.ofSeconds(60 * 60 * 24 * 7));
        // 2.4 将新的用户登录信息设置到Context中
        SecurityContextHolder.set(loginUser);

        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put(SecurityConstant.USER_KEY, newUserKey);

        return JwtUtils.createToken(claimsMap);
    }

    public String getUserKey(String token) {
        return JwtUtils.getUserKey(token);
    }

    public void delLoginUser(String token) {
        String cacheKeyPrefix = IRedisKey.ADMIN_LOGIN_PREFIX + TenantContextHolder.getTenantId();
        String cacheKeyUserKey = cacheKeyPrefix + ":" + getUserKey(token);
        LoginUser loginUser = (LoginUser) redisUtil.get(cacheKeyUserKey);
        redisUtil.remove(cacheKeyPrefix + ":" + getUserKey(token));
        redisUtil.remove(cacheKeyPrefix + ":" + loginUser.getUsername());
    }

    public String getToken() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return requestAttributes.getRequest().getHeader(SecurityConstant.HEADER_TOKEN);
    }

    public boolean checkToken(String token, String tenantId) {
        if(StringUtils.isBlank(token)) {
            return false;
        }
        String cacheKeyPrefix = IRedisKey.ADMIN_LOGIN_PREFIX + tenantId;
        String cacheKeyUserKey = cacheKeyPrefix + ":" + getUserKey(token);
        return redisUtil.exists(cacheKeyUserKey);
    }

    public LoginUser getLoginUser() {
        String cacheKeyPrefix = IRedisKey.ADMIN_LOGIN_PREFIX + TenantContextHolder.getTenantId();
        String cacheKeyUserKey = cacheKeyPrefix + ":" + getUserKey(getToken());
        if (!redisUtil.exists(cacheKeyUserKey)) {
            return null;
        }
        SecurityContextHolder.set((LoginUser) redisUtil.get(cacheKeyUserKey));
        return SecurityContextHolder.get();
    }
}
