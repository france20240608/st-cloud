package com.st.cloud.module.user.dto;

import com.st.cloud.common.pojo.BaseReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemberUserReqDTO extends BaseReqDTO {
    private Long id;
    private String username;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer type;
    private Integer level;
}
