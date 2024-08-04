package com.st.cloud.framework.security.core.util;


import cn.hutool.core.util.ObjectUtil;
import com.st.cloud.common.exception.auth.NotLoginException;
import com.st.cloud.common.exception.auth.NotPermissionException;
import com.st.cloud.framework.security.core.aop.Logical;
import com.st.cloud.framework.security.core.aop.RequiresPermissions;
import com.st.cloud.framework.security.core.service.TokenService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import java.util.Collection;
import java.util.Set;

/**
 * Token 权限验证工具类
 * 
 * @author Tim
 */
@Slf4j
@Component
public class AuthUtil {

    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";

    @Resource
    private TokenService tokenService;

    public boolean checkToken(String token, String tenantId) {
        try {
            return tokenService.checkToken(token, tenantId);
        } catch (Exception e) {
            log.error(" AuthUtil-checkToken 检查token失败", e);
            return false;
        }

    }

    /**
     * 会话注销
     */
    public void logout() {
        String token = tokenService.getToken();
        logoutByToken(token);
    }

    /**
     * 会话注销，根据指定Token
     * 
     * @param token 指定token
     */
    public void logoutByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return;
        }
        tokenService.delLoginUser(token);
    }

    /**
     * 检验当前会话是否已经登录，如未登录，则抛出异常
     */
    public void checkLogin() {
        if (ObjectUtil.isNull(tokenService.getLoginUser())) {
            throw new NotLoginException("无效的token");
        }
    }

    /**
     * 根据注解传入参数鉴权, 如果验证未通过，则抛出异常: NotPermissionException
     * 
     * @param requiresPermissions 权限注解
     */
    public void checkPermi(RequiresPermissions requiresPermissions) {
        if (requiresPermissions.logical() == Logical.AND) {
            checkPermiAnd(requiresPermissions.value());
        } else {
            checkPermiOr(requiresPermissions.value());
        }
    }

    /**
     * 当前账号是否含有指定权限 [指定多个，必须全部验证通过]
     * 
     * @param permissions 权限码数组
     */
    public void checkPermiAnd(String... permissions) {
        Set<String> permissionList = tokenService.getLoginUser().getPermissions();
        for (String permission : permissions) {
            if (!hasPermi(permissionList, permission)) {
                throw new NotPermissionException(permission);
            }
        }
    }

    /**
     * 当前账号是否含有指定权限 [指定多个，只要其一验证通过即可]
     *
     * @param permissions 权限码数组
     */
    public void checkPermiOr(String... permissions) {
        Set<String> permissionList = tokenService.getLoginUser().getPermissions();
        for (String permission : permissions) {
            if (hasPermi(permissionList, permission)) {
                return;
            }
        }
        if (permissions.length > 0) {
            throw new NotPermissionException(permissions);
        }
    }

    /**
     * 判断是否包含权限
     *
     * @param authorities 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(Collection<String> authorities, String permission) {
        return authorities.stream()
                .filter(StringUtils::isNotBlank)
                .anyMatch(x -> ALL_PERMISSION.equals(x) || PatternMatchUtils.simpleMatch(x, permission));
    }
}
