package com.st.cloud.agent.service.impl;

import com.st.cloud.agent.common.BizConstant;
import com.st.cloud.agent.pojo.convert.MemberUserVOConvert;
import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.UserApi;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private UserApi userApi;

    @Override
    public CommonResult<MemberUserVO> getMemberByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        reqDTO.setType(BizConstant.MEMBER_TYPE_MEMBER);
        CommonResult<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData())) {
          return CommonResult.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return CommonResult.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public CommonResult<MemberUserVO> getAdminByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        reqDTO.setType(BizConstant.MEMBER_TYPE_ADMIN);
        CommonResult<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData())) {
            return CommonResult.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return CommonResult.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public CommonResult<MemberUserVO> getUserByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        CommonResult<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData())) {
            return CommonResult.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return CommonResult.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public CommonResult<MemberUserVO> login(LoginVO vo) {
        return null;
    }


}
