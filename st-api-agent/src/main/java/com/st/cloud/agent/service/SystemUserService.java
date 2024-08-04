package com.st.cloud.agent.service;

import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.common.pojo.R;

public interface SystemUserService {
    R<MemberUserVO> getMemberByUsername(String username);

    R<MemberUserVO> getAdminByUsername(String username);

    R<MemberUserVO> getUserByUsername(String username);

    R<LoginVO> login(LoginVO vo);
}
