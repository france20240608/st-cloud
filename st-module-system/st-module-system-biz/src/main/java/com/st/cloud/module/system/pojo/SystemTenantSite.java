package com.st.cloud.module.system.pojo;

import com.st.cloud.framework.tenant.core.pojo.TenantBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemTenantSite extends TenantBaseDO {
    private Long id;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
