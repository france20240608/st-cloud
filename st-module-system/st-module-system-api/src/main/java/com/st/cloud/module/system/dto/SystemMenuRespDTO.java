package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemMenuRespDTO extends BaseRespDTO {
    private Long id;
    private String name;
    private String permission;
    private String path;
    private Long parentId;
    private Integer sort;
    private String icon;
    private String i18nTag;
    private Integer type;
    private Integer status;
    private Integer visible;
}
