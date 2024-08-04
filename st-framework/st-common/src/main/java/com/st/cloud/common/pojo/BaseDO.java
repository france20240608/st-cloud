package com.st.cloud.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDO implements Serializable {

    private LocalDateTime createTime;
    private String createUser;
    private LocalDateTime updateTime;
    private String updateUser;
}
