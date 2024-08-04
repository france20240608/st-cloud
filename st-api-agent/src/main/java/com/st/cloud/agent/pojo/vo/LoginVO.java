package com.st.cloud.agent.pojo.vo;

import com.st.cloud.common.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginVO extends BaseVO {
    private String username;
    private String password;
    private Set<SystemMenuVO> menus;
    private String token;
}
