package com.st.cloud.module.agent.pojo.ob;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import com.st.cloud.common.pojo.BaseVO;
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
