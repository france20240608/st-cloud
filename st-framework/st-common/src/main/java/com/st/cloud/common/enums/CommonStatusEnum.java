package com.st.cloud.common.enums;

import cn.hutool.core.util.ObjUtil;
import com.st.cloud.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 通用状态枚举
 *
 * @author tim
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum implements IntArrayValuable {

    OFF(0, "OFF"),
    ON(1, "ON");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CommonStatusEnum::getStatus).toArray();

    /**
     * 状态值
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

    public static boolean isEnable(Integer status) {
        return ObjUtil.equal(ON.status, status);
    }

    public static boolean isDisable(Integer status) {
        return ObjUtil.equal(OFF.status, status);
    }

}
