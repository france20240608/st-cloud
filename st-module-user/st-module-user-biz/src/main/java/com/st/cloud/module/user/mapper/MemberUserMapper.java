package com.st.cloud.module.user.mapper;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.framework.tenant.core.TenantConstant;
import com.st.cloud.module.user.enums.CacheKey;
import com.st.cloud.module.user.pojo.MemberUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberUserMapper extends BaseMapper<MemberUser> {

    MemberUser getUserByUserId(@Param("id") Long id);

    @Cached(name= CacheKey.modulePrefix + "user:", key= TenantConstant.cacheKeyPrefix + "args[0]", expire = 3600)
    MemberUser getUserByUsername(@Param("username") String username);

    @Cached
    MemberUser getAdminLoginUser(String username, Integer type, Long tenantId);
}
