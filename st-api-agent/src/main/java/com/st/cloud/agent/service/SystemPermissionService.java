package com.st.cloud.agent.service;

import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.common.pojo.R;

import java.util.List;

public interface SystemPermissionService {
    R<List<SystemMenuVO>> getMenuList(SystemMenuVO vo);
    R<List<SystemMenuVO>> getRoleMenuList(SystemMenuVO vo);
}
