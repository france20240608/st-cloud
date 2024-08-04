package com.st.cloud.common.enums;

import cn.hutool.core.util.ArrayUtil;
import com.st.cloud.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 时间间隔的枚举
 *
 * @author Tim
 */
@Getter
@AllArgsConstructor
public enum DateIntervalEnum implements IntArrayValuable {

    DAY(1, "DAY"),
    WEEK(2, "WEEK"),
    MONTH(3, "MONTH"),
    QUARTER(4, "QUARTER"),
    YEAR(5, "YEAR")
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(DateIntervalEnum::getInterval).toArray();

    /**
     * 类型
     */
    private final Integer interval;
    /**
     * 名称
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

    public static DateIntervalEnum valueOf(Integer interval) {
        return ArrayUtil.firstMatch(item -> item.getInterval().equals(interval), DateIntervalEnum.values());
    }

}