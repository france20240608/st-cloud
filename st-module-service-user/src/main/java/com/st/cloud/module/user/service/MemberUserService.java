package com.st.cloud.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.user.pojo.ob.MemberUserDO;

public interface MemberUserService extends IService<MemberUserDO> {
    MemberUserDO getUserByUserId(Long id);
}
