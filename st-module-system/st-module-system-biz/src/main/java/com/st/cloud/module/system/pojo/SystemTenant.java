package com.st.cloud.module.system.pojo;

import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SystemTenant extends BaseDO {
    private Long id;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
