package com.st.cloud.framework.security.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.st.cloud.framework.security.core.entity.LoginUser;

public class SecurityContextHolder {
    private static final TransmittableThreadLocal<LoginUser> THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static void set(LoginUser loginUser) {
        THREAD_LOCAL.set(loginUser);
    }

    public static LoginUser get() {
        return THREAD_LOCAL.get();
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}
