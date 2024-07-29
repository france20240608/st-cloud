package com.st.cloud.agent.service;

import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.common.pojo.CommonResult;

public interface SystemUserService {
    CommonResult<MemberUserVO> getMemberByUsername(String username);

    CommonResult<MemberUserVO> getAdminByUsername(String username);

    CommonResult<MemberUserVO> getUserByUsername(String username);

    CommonResult<MemberUserVO> login(LoginVO vo);
}
