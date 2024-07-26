package com.st.cloud.module.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;

public interface MemberUserService extends IService<MemberUserDO> {
    MemberUserDO getByUsername(String username);
}
