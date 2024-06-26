package com.st.cloud.module.user.mapper;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.user.entity.bo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Cached(name="userCache.", key = "#id", expire = 3600, cacheType = CacheType.BOTH, cacheNullValue = true)
    User getUserByUserId(Long id);
}
