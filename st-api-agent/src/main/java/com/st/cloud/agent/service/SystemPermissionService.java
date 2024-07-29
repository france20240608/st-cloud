package com.st.cloud.agent.service;

import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.common.pojo.CommonResult;

import java.util.List;

public interface SystemPermissionService {
    CommonResult<List<SystemMenuVO>> getMenuList(SystemMenuVO vo);
    CommonResult<List<SystemMenuVO>> getRoleMenuList(SystemMenuVO vo);
}
