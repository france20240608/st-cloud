package com.st.cloud.agent.pojo.ob;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_site")
public class SystemSiteDO extends BaseDO {
    private Long id;
    private Integer tenantId;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
