package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemRoleReqDTO extends BaseReqDTO {
    private Long id;
    private String name;
    private Long parentId;
    private Integer status;
}
