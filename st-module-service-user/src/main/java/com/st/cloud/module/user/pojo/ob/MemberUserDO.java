package com.st.cloud.module.user.pojo.ob;


import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@TableName("member_user")
@Data
public class MemberUserDO extends BaseDO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer tenantId;
    private Integer deleted;
}
