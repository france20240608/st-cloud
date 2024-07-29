package com.st.cloud.module.user.dto;

import com.st.cloud.common.pojo.BaseRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemberUserRespDTO extends BaseRespDTO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer type;
    private Integer level;
}
