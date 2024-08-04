package com.st.cloud.framework.security.core.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginUser {
    private Long id;
    private String username;
    private String loginIp;
    private Set<String> permissions = new HashSet<>();
}
