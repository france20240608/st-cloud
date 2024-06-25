package com.st.cloud.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.user.entity.bo.User;
import com.st.cloud.module.user.mapper.UserMapper;
import com.st.cloud.module.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByUserId(Long id){
        return userMapper.getUserByUserId(id);
    }
}
