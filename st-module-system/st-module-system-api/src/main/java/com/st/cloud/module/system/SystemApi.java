package com.st.cloud.module.system;


import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.st.cloud.common.base.ApiPrefixConstant.API_PREFIX_SYSTEM;

@FeignClient(name = "st-module-system-biz")
public interface SystemApi {
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getMenuList")
    CommonResult<List<SystemMenuRespDTO>> getMenuList(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getMenuDetail")
    CommonResult<SystemMenuRespDTO> getMenuDetail(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/tenantsite/getTenantId")
    CommonResult<SystemTenantSiteRespDTO> getTenantId(@RequestBody SystemTenantSiteReqDTO dto);
}
