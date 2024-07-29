package com.st.cloud.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import com.st.cloud.framework.tenant.core.db.TenantBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_tenant_site")
public class SystemTenantSiteDO extends TenantBaseDO {
    private Long id;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
