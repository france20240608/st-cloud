package com.st.cloud.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult() {
        this.code = "0000";
        this.message = "success";
    }
}
