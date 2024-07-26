package com.st.cloud.module.user.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberUserDTO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer tenantId;
    private Integer deleted;
    private LocalDateTime createTime;
    private String createUser;
    private LocalDateTime updateTime;
    private String updateUser;
}
