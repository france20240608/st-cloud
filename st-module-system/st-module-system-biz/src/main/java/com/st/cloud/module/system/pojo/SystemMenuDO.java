package com.st.cloud.module.user.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("system_menu")
@Data
public class SystemMenuDO extends BaseDO {
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
