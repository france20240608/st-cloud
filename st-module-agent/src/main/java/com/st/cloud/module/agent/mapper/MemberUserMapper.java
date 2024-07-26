package com.st.cloud.module.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberUserMapper extends BaseMapper<MemberUserDO> {
    MemberUserDO getByUsername(@Param("username") String username);
}
