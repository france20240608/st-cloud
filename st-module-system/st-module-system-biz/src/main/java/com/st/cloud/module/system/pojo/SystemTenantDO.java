package com.st.cloud.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_tenant")
public class SystemTenantDO extends BaseDO {
    private Long id;
    private Integer tenantId;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
