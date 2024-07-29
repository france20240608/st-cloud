package com.st.cloud.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import com.st.cloud.module.user.pojo.MemberUserDO;

public interface MemberUserService extends IService<MemberUserDO> {
    MemberUserDO getUserByUserId(Long id);

    CommonResult<MemberUserRespDTO> getUserByUsername(String username);

    MemberUserDO getAdminByUserId(Long id);

    CommonResult<MemberUserRespDTO> getAdminByUsername(String username);

    CommonResult<AdminLoginRespDTO> adminLogin(AdminLoginReqDTO dto);
}
