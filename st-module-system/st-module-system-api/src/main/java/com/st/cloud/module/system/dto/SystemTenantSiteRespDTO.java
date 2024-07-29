package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemTenantSiteRespDTO extends BaseRespDTO {
    private Long id;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
