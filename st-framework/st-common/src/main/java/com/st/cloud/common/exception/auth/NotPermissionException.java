package com.st.cloud.common.exception.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * 未能通过的权限认证异常
 * 
 * @author Tim
 */
public class NotPermissionException extends RuntimeException {
    public NotPermissionException(String permission) {
        super(permission);
    }

    public NotPermissionException(String[] permissions) {
        super(StringUtils.join(permissions, ","));
    }
}
