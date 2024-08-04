package com.st.cloud.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseReqDTO implements Serializable {

    private Long tenantId;

    private LocalDateTime createTime;
    private String createUser;
    private LocalDateTime updateTime;
    private String updateUser;

    private Integer pageNum = 1;
    private Integer pageSize = 20;
}
