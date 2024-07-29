package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemTenantSiteReqDTO extends BaseReqDTO {
    private Long id;
    private Integer tenantId;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
