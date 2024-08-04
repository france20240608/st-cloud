package com.st.cloud.common.exception.auth;

/**
 * 未能通过的登录认证异常
 * 
 * @author Tim
 */
public class NotLoginException extends RuntimeException {
    public NotLoginException(String message) {
        super(message);
    }
}
