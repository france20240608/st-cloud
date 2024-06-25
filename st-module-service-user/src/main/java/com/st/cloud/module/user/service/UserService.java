package com.st.cloud.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.user.entity.bo.User;

public interface UserService extends IService<User> {
    User getUserByUserId(Long id);
}
