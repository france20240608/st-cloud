package com.st.cloud.module.user.dto;

import com.st.cloud.common.pojo.BaseReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminLoginReqDTO extends BaseReqDTO {
    private String username;
    private String password;
    private Integer type;
}
