package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemMenuReqDTO extends BaseReqDTO {
    private Long id;
    private String name;
    private String permission;
    private String path;
    private Long parentId;
    private Integer sort;
    private String icon;
    private Integer type;
    private Integer status;
    private Integer visible;
}
