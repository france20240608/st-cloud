package com.st.cloud.agent.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.st.cloud.agent.pojo.convert.SystemMenuVOConvert;
import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.agent.service.SystemPermissionService;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.SystemApi;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPermissionServiceImpl implements SystemPermissionService {

    @Resource
    private SystemApi systemApi;

    @Override
    public R<List<SystemMenuVO>> getMenuList(SystemMenuVO vo) {
        SystemMenuReqDTO dto = new SystemMenuReqDTO();
        BeanUtils.copyProperties(vo, dto);
        R<List<SystemMenuRespDTO>> menuList = systemApi.getMenuList(dto);
        if(ObjectUtil.isNotNull(menuList.getData())) {
            return R.success(SystemMenuVOConvert.INSTANCE.convert(menuList.getData()));
        }
        return R.fail(menuList.getCode(), menuList.getMessage());
    }

    @Override
    public R<List<SystemMenuVO>> getRoleMenuList(SystemMenuVO vo) {
        SystemMenuReqDTO dto = new SystemMenuReqDTO();
        BeanUtils.copyProperties(vo, dto);
        R<List<SystemMenuRespDTO>> menuList = systemApi.getMenuList(dto);
        if(ObjectUtil.isNotNull(menuList.getData())) {
            return R.success(SystemMenuVOConvert.INSTANCE.convert(menuList.getData()));
        }
        return R.fail(menuList.getCode(), menuList.getMessage());
    }
}
