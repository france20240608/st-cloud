package com.st.cloud.agent.pojo.vo;

import com.st.cloud.common.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginVO extends BaseVO {
    public String username;
    public String password;
}
