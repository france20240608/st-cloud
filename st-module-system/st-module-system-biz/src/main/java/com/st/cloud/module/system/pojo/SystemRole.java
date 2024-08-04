package com.st.cloud.module.system.pojo;

import com.st.cloud.framework.tenant.core.pojo.TenantBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SystemRole extends TenantBaseDO {
    private Long id;
    private String name;
    private Long parentId;
    private Integer status;
}
