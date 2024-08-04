package com.st.cloud.common.core;

import java.time.Duration;

public interface IRedisKey {

    String ADMIN_LOGIN_PREFIX = "agent:login:";

    String key(String... keys);
    String keyWithTenant(String... keys);

    Duration duration();
}
