package com.st.cloud.module.user.dto;

import com.st.cloud.common.pojo.BaseRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminLoginRespDTO extends BaseRespDTO {
    private Long id;
    private String username;
}
