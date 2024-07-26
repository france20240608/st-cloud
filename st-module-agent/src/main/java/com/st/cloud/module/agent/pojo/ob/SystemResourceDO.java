package com.st.cloud.module.agent.pojo.ob;

import com.baomidou.mybatisplus.annotation.TableName;
import com.st.cloud.common.pojo.BaseDO;
import com.st.cloud.common.pojo.BaseVO;
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
