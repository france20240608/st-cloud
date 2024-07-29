package com.st.cloud.agent.service;

import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.dto.MemberUserRespDTO;

public interface SystemUserService {
    CommonResult<MemberUserRespDTO> getMemberByUsername(String username);

    CommonResult<MemberUserRespDTO> getAdminByUsername(String username);

    CommonResult<MemberUserRespDTO> getUserByUsername(String username);
}
