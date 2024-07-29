package com.st.cloud.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import com.st.cloud.module.user.mapper.MemberUserMapper;
import com.st.cloud.module.user.pojo.MemberUserDO;
import com.st.cloud.module.user.service.MemberUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUserDO> implements MemberUserService {
    @Resource
    MemberUserMapper memberUserMapper;

    @Override
    public MemberUserDO getUserByUserId(Long id){
        return memberUserMapper.getUserByUserId(id);
    }

    @Override
    public CommonResult<MemberUserRespDTO> getUserByUsername(String username) {
        MemberUserRespDTO respDTO = new MemberUserRespDTO();
        MemberUserDO user = memberUserMapper.getUserByUsername(username);
        BeanUtils.copyProperties(user, respDTO);
        return CommonResult.success(respDTO);
    }

    @Override
    public MemberUserDO getAdminByUserId(Long id) {
        return null;
    }

    @Override
    public CommonResult<MemberUserRespDTO> getAdminByUsername(String username) {
        return null;
    }

    @Override
    public CommonResult<AdminLoginRespDTO> adminLogin(AdminLoginReqDTO dto) {
        MemberUserDO userByUsername = memberUserMapper.getUserByUsername(dto.getUsername());
        if(Objects.isNull(userByUsername)) {
            return CommonResult.fail("0001","用户不存在");
        }

        BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder();
        if(!bencoder.matches(dto.getPassword(), userByUsername.getPassword())) {
            return CommonResult.fail("0002","用户名或者密码错误");
        }

        if(userByUsername.getLoginStatus() != 1) {
            return CommonResult.fail("0002","用户已禁用");
        }

        AdminLoginRespDTO respDTO = new AdminLoginRespDTO();
        BeanUtils.copyProperties(userByUsername, respDTO);

        return CommonResult.success(respDTO);
    }
}
