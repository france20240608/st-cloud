package com.st.cloud.module.system.dto;

import com.st.cloud.common.pojo.BaseRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemPermissionRespDTO extends BaseRespDTO {
    private Long id;
    private Set<String> permissions;
    private Set<SystemMenuRespDTO> menus;
}
