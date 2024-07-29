package com.st.cloud.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private T data;

    public CommonResult(String code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public CommonResult() {
        this.code = "0000";
        this.message = "成功";
        this.success = true;
    }

    public CommonResult(T data) {
        this();
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(data);
    }

    public static <T> CommonResult<T> fail(String code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }

    public static <T> CommonResult<T> fail(CommonResult cr) {
        CommonResult<T> result = new CommonResult<>();
        result.setMessage(cr.getMessage());
        result.setCode(cr.getCode());
        return result;
    }
}
