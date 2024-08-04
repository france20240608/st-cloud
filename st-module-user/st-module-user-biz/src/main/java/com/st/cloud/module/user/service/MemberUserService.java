package com.st.cloud.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import com.st.cloud.module.user.pojo.MemberUser;

public interface MemberUserService extends IService<MemberUser> {
    MemberUser getUserByUserId(Long id);

    R<MemberUserRespDTO> getUserByUsername(String username);

    MemberUser getAdminByUserId(Long id);

    R<MemberUserRespDTO> getAdminByUsername(String username);

    R<AdminLoginRespDTO> adminLogin(AdminLoginReqDTO dto);

    R<AdminLoginRespDTO> getAdminLoginUser(AdminLoginReqDTO dto);
}
