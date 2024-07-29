package com.st.cloud.module.user;


import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.st.cloud.common.base.ApiPrefixConstant.API_PREFIX_USER;

@FeignClient(name = "st-module-user-biz")
public interface UserApi {

    @PostMapping(API_PREFIX_USER + "/member/getUserByUserId")
    CommonResult<MemberUserRespDTO> getUserByUserId(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/member/getUserByUsername")
    CommonResult<MemberUserRespDTO> getUserByUsername(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/admin/getUserByUserId")
    CommonResult<MemberUserRespDTO> getAdminByUserId(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/admin/getUserByUsername")
    CommonResult<MemberUserRespDTO> getAdminByUsername(@RequestBody MemberUserReqDTO dto);

}
