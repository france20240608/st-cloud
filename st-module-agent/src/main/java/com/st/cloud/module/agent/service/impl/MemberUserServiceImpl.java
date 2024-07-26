package com.st.cloud.module.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.agent.mapper.MemberUserMapper;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import com.st.cloud.module.agent.service.MemberUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUserDO> implements MemberUserService {

    @Resource
    private MemberUserMapper memberUserMapper;

    @Override
    public MemberUserDO getByUsername(String username) {
        return memberUserMapper.getByUsername(username);
    }
}
