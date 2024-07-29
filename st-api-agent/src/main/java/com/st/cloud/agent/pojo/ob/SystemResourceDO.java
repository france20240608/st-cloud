package com.st.cloud.agent.pojo.ob;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import lombok.Data;

@Data
@TableName("system_resource")
public class SystemResourceDO extends BaseDO {
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
