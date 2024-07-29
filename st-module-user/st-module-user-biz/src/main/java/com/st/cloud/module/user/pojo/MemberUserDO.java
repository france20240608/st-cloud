package com.st.cloud.module.user.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.framework.tenant.core.db.TenantBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@TableName("member_user")
@Data
public class MemberUserDO extends TenantBaseDO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer type;
    private Integer level;
}
