package com.st.cloud.agent.service.impl;

import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.UserApi;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private UserApi userApi;

    @Override
    public CommonResult<MemberUserRespDTO> getMemberByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        return userApi.getUserByUsername(reqDTO);
    }

    @Override
    public CommonResult<MemberUserRespDTO> getAdminByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        return userApi.getAdminByUsername(reqDTO);
    }

    @Override
    public CommonResult<MemberUserRespDTO> getUserByUsername(String username) {
        return null;
    }


}
