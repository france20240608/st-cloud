package com.st.cloud.module.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.common.constants.BizConstant;
import com.st.cloud.common.pojo.R;
import com.st.cloud.framework.tenant.core.aop.TenantMust;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import com.st.cloud.module.user.mapper.MemberUserMapper;
import com.st.cloud.module.user.pojo.MemberUser;
import com.st.cloud.module.user.service.MemberUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUser> implements MemberUserService {
    @Resource
    MemberUserMapper memberUserMapper;

    @Override
    public MemberUser getUserByUserId(Long id){
        return memberUserMapper.getUserByUserId(id);
    }

    @Override
    public R<MemberUserRespDTO> getUserByUsername(String username) {
        MemberUserRespDTO respDTO = new MemberUserRespDTO();
        MemberUser user = memberUserMapper.getUserByUsername(username);
        BeanUtils.copyProperties(user, respDTO);
        return R.success(respDTO);
    }

    @Override
    public MemberUser getAdminByUserId(Long id) {
        return null;
    }

    @Override
    public R<MemberUserRespDTO> getAdminByUsername(String username) {
        return null;
    }

    @Override
    public R<AdminLoginRespDTO> adminLogin(AdminLoginReqDTO dto) {
        MemberUser userByUsername = memberUserMapper.getUserByUsername(dto.getUsername());
        if(Objects.isNull(userByUsername)) {
            return R.fail("99999","用户不存在");
        }

        BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder();
        if(!bencoder.matches(dto.getPassword(), userByUsername.getPassword())) {
            return R.fail("99999","用户名或者密码错误");
        }

        if(userByUsername.getLoginStatus() != 1) {
            return R.fail("99999","用户已禁用");
        }

        AdminLoginRespDTO respDTO = new AdminLoginRespDTO();
        BeanUtils.copyProperties(userByUsername, respDTO);

        return R.success(respDTO);
    }

    @TenantMust // 这里无论是系统租户还是普通租户，都必须使用到tenant_id，系统租户不会注入tenantId，所以要特殊处理一下
    @Override
    public R<AdminLoginRespDTO> getAdminLoginUser(AdminLoginReqDTO dto) {
        MemberUser user = memberUserMapper.getAdminLoginUser(dto.getUsername(), dto.getType(), dto.getTenantId());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(ObjectUtil.isNull(user)) {
            return R.fail("99999", "用户不存在");
        } else if (!BizConstant.MEMBER_TYPE_ADMIN.equals(user.getType())) {
            return R.fail("99999", "用户不是管理员");
        } else if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            return R.fail("99999", "账号或者密码错误");
        }

        AdminLoginRespDTO respDTO = new AdminLoginRespDTO();
        respDTO.setId(user.getId());
        respDTO.setUsername(user.getUsername());
        return R.success(respDTO);
    }
}
