package com.st.cloud.module.system.controller;


import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.service.SystemMenuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.st.cloud.common.base.ApiPrefixConstant.API_PREFIX_SYSTEM;


@RestController
@RequestMapping(API_PREFIX_SYSTEM + "/menu")
@Slf4j
public class SystemMenuController {

    @Resource
    private SystemMenuService systemMenuService;

    @PostMapping("/getMenuList")
    public CommonResult<List<SystemMenuRespDTO>> getMenuList(@RequestBody SystemMenuRespDTO dto) {
        return CommonResult.success(systemMenuService.getMenuList(dto));
    }

    @PostMapping("/getMenuDetail")
    public CommonResult<SystemMenuRespDTO> getMenuDetail(@RequestBody SystemMenuRespDTO dto) {
        return CommonResult.success(systemMenuService.getMenuDetail(dto));
    }

}
