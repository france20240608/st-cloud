package com.st.cloud.agent.pojo.vo;

import com.st.cloud.common.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemMenuVO extends BaseVO {
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
    private Integer RoleId;
}
