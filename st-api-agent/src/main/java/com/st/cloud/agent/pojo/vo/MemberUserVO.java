package com.st.cloud.agent.pojo.vo;

import com.st.cloud.common.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemberUserVO extends BaseVO {
    private Long id;
    private String username;
    private String password;
    private Integer loginStatus;
    private Integer betStatus;
    private LocalDateTime lastLoginTime;
    private Integer type;
    private Integer level;
}
