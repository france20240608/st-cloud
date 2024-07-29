package com.st.cloud.module.user.mapper;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.user.pojo.MemberUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberUserMapper extends BaseMapper<MemberUserDO> {
    @Cached(name="userCache.", key = "#id", expire = 10, cacheType = CacheType.BOTH, cacheNullValue = true)
    MemberUserDO getUserByUserId(@Param("idd") Long id);

    @Cached(name="userCache.", key = "#username", expire = 10, cacheType = CacheType.BOTH, cacheNullValue = true)
    MemberUserDO getUserByUsername(@Param("username") String username);
}
