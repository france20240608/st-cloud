package com.st.cloud.agent.controller.permission;

import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.agent.service.SystemPermissionService;
import com.st.cloud.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.st.cloud.common.base.ApiPrefixConstant.API_PREFIX_AGENT;

@RestController
@RequestMapping( API_PREFIX_AGENT + "/permission")
public class SystemPermissionController {

    @Resource
    private SystemPermissionService systemPermissionService;

    @PostMapping("/getMenuList")
    @Operation(summary = "菜单管理，不含血缘 - 系统管理员编辑菜单时查询所有的菜单")
    public CommonResult<List<SystemMenuVO>> getMenuList(@RequestBody SystemMenuVO vo) {
        return systemPermissionService.getMenuList(vo);
    }

    @PostMapping("/getRoleMenuList")
    @Operation(summary = "权限管理，含血缘 - 给角色赋予权限的时候，只能获取自身角所持有的权限")
    public CommonResult<List<SystemMenuVO>> getRoleMenuList(@RequestBody SystemMenuVO vo) {
        return systemPermissionService.getRoleMenuList(vo);
    }

}
