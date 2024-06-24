package com.st.cloud.module.user.service;

import com.st.cloud.framework.db.config.ReadOnly;
import com.st.cloud.module.user.entity.bo.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();
}
