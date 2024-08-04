package com.st.cloud.agent.service.impl;

import com.st.cloud.agent.pojo.convert.MemberUserVOConvert;
import com.st.cloud.agent.pojo.convert.SystemMenuVOConvert;
import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.constants.BizConstant;
import com.st.cloud.common.pojo.R;
import com.st.cloud.framework.redis.core.RedisUtil;
import com.st.cloud.framework.security.core.entity.LoginUser;
import com.st.cloud.framework.security.core.service.TokenService;
import com.st.cloud.module.system.SystemApi;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.user.UserApi;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private UserApi userApi;
    @Resource
    private SystemApi systemApi;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private TokenService tokenService;

    @Override
    public R<MemberUserVO> getMemberByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        reqDTO.setType(BizConstant.MEMBER_TYPE_MEMBER);
        R<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData()) && userByUsername.isSuccess()) {
          return R.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return R.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public R<MemberUserVO> getAdminByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        reqDTO.setType(BizConstant.MEMBER_TYPE_ADMIN);
        R<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData()) && userByUsername.isSuccess()) {
            return R.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return R.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public R<MemberUserVO> getUserByUsername(String username) {
        MemberUserReqDTO reqDTO = new MemberUserReqDTO();
        reqDTO.setUsername(username);
        R<MemberUserRespDTO> userByUsername = userApi.getUserByUsername(reqDTO);
        if(Objects.nonNull(userByUsername.getData()) && userByUsername.isSuccess()) {
            return R.success(MemberUserVOConvert.INSTANCE.convert(userByUsername.getData()));
        }
        return R.fail(userByUsername.getCode(), userByUsername.getMessage());
    }

    @Override
    public R<LoginVO> login(LoginVO vo) {
        LoginVO returnVO = new LoginVO();
        // 用户中心验证用户名和密码是否正确，正确返回用户登录后需要的信息
        AdminLoginReqDTO dto = new AdminLoginReqDTO();
        dto.setUsername(vo.getUsername());
        dto.setPassword(vo.getPassword());
        dto.setType(BizConstant.MEMBER_TYPE_ADMIN);
        R<AdminLoginRespDTO> adminByUsername = userApi.getAdminLoginUser(dto);
        // 验证成功
        if(adminByUsername.isSuccess()) {

            AdminLoginRespDTO data = adminByUsername.getData();
            LoginUser loginUser = new LoginUser();

            R<List<SystemMenuRespDTO>> userPermission = systemApi.getAdminPermission(data.getId());
            Set<String> permissions = new HashSet<>();
            Set<SystemMenuVO> menus = getMenus(userPermission, permissions);
            loginUser.setUsername(data.getUsername());
            loginUser.setId(data.getId());
            loginUser.setPermissions(permissions);

            returnVO.setMenus(menus);
            returnVO.setToken(tokenService.createToken(loginUser));
            // 将token返回给前端
            return R.success(returnVO);
        }
        return R.fail(adminByUsername);
    }

    @NotNull
    private static Set<SystemMenuVO> getMenus(R<List<SystemMenuRespDTO>> userPermission, Set<String> permissions) {
        Set<SystemMenuVO> menus = new HashSet<>();
        if(userPermission.isSuccess()) {
            List<SystemMenuRespDTO> menuRespList = userPermission.getData();
            menuRespList.forEach(l -> {
                permissions.add(l.getPermission());
                SystemMenuVO convert = SystemMenuVOConvert.INSTANCE.convert(l);
                // 不给前端返回具体的权限标识
                convert.setPermission(null);
                menus.add(convert);
            });
        }
        return menus;
    }
}
