package com.st.cloud.agent.pojo.vo;

import com.st.cloud.common.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemMenuVO extends BaseVO {
    private Long id;
    private Integer tenantId;
    private String name;
    private String domain;
    private Integer status;
    private Integer type;
}
