package com.st.cloud.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.user.mapper.MemberUserMapper;
import com.st.cloud.module.user.pojo.ob.MemberUserDO;
import com.st.cloud.module.user.service.MemberUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUserDO> implements MemberUserService {
    @Resource
    MemberUserMapper memberUserMapper;

    @Override
    public MemberUserDO getUserByUserId(Long id){
        return memberUserMapper.getUserByUserId(id);
    }
}
