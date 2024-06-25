package com.st.cloud.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.user.entity.bo.User;

public interface UserMapper extends BaseMapper<User> {
    User getUserByUserId(Long id);
}
