package com.st.cloud.module.agent.api;

import com.st.cloud.common.core.CommonResult;
import com.st.cloud.module.agent.pojo.dto.MemberUserDTO;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "st-module-service-user")
public interface UserApi {

    @PostMapping("/user/getUserByUserId")
    CommonResult<MemberUserDO> getUserByUserId(@RequestBody MemberUserDTO dto);
}
