package com.st.cloud.module.user.service.impl;

import com.st.cloud.framework.db.config.ReadOnly;
import com.st.cloud.module.user.entity.bo.User;
import com.st.cloud.module.user.repository.UserRepository;
import com.st.cloud.module.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @ReadOnly
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
