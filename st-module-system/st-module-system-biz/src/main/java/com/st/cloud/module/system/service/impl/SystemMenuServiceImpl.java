package com.st.cloud.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.system.convert.SystemMenuDTOConvert;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.mapper.SystemMenuMapper;
import com.st.cloud.module.system.pojo.SystemMenuDO;
import com.st.cloud.module.system.service.SystemMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenuDO> implements SystemMenuService {
    @Resource
    SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenuRespDTO> getMenuList(SystemMenuRespDTO dto) {
        List<SystemMenuDO> list = systemMenuMapper.getMenuList(dto);
        return SystemMenuDTOConvert.INSTANCE.convert(list);
    }

    @Override
    public SystemMenuRespDTO getMenuDetail(SystemMenuRespDTO dto) {
        SystemMenuDO detail = systemMenuMapper.getMenuDetail(dto);
        return SystemMenuDTOConvert.INSTANCE.convert(detail);
    }
}
