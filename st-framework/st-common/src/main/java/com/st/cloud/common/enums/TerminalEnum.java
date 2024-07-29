package com.st.cloud.common.enums;

import com.st.cloud.common.core.IntArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 终端的枚举
 *
 * @author Tim
 */
@RequiredArgsConstructor
@Getter
public enum TerminalEnum implements IntArrayValuable {

    UNKNOWN(0, "未知"), // 目的：在无法解析到 terminal 时，使用它
    H5(1, "H5"),
    IOS(2, "IOS"),
    ANDROID(3, "ANDROID"),
    PC(4, "PC"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(TerminalEnum::getTerminal).toArray();

    /**
     * 终端
     */
    private final Integer terminal;
    /**
     * 终端名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
