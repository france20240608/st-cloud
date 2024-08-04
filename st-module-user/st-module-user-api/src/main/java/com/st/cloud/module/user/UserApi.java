package com.st.cloud.module.user;


import com.st.cloud.common.pojo.R;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_USER;

@FeignClient(name = "st-module-user-biz")
public interface UserApi {

    @PostMapping(API_PREFIX_USER + "/member/getUserByUserId")
    R<MemberUserRespDTO> getUserByUserId(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/member/getUserByUsername")
    R<MemberUserRespDTO> getUserByUsername(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/admin/getUserByUserId")
    R<MemberUserRespDTO> getAdminByUserId(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/admin/getUserByUsername")
    R<MemberUserRespDTO> getAdminByUsername(@RequestBody MemberUserReqDTO dto);

    @PostMapping(API_PREFIX_USER + "/admin/getAdminLoginUser")
    R<AdminLoginRespDTO> getAdminLoginUser(@RequestBody AdminLoginReqDTO dto);

}
