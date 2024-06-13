package com.st.cloud.common.enums;

import cn.hutool.core.util.ArrayUtil;
import com.st.cloud.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 全局用户类型枚举
 */
@AllArgsConstructor
@Getter
public enum UserTypeEnum implements IntArrayValuable {

    OWNER(0, "OWNER"), // 厅主
    L1_HOLDER(1, "L1_HOLDER"), // 大股东
    L2_HOLDER(2, "L2_HOLDER"), // 股东
    L3_AGENT(3, "L3_AGENT"), // 代理
    L4_AGENT(4, "L4_AGENT"), // 代理
    L5_AGENT(5, "L5_AGENT"), // 代理
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnum::getValue).toArray();

    /**
     * 类型
     */
    private final Integer value;
    /**
     * 类型名
     */
    private final String name;

    public static UserTypeEnum valueOf(Integer value) {
        return ArrayUtil.firstMatch(userType -> userType.getValue().equals(value), UserTypeEnum.values());
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
