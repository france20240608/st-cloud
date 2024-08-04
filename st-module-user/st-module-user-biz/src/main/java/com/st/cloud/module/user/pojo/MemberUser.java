package com.st.cloud.module.user.pojo;


import com.st.cloud.framework.tenant.core.pojo.TenantBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemberUser extends TenantBaseDO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer type;
    private Integer level;
}
