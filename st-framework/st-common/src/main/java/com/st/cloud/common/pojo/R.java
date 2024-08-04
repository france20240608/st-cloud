package com.st.cloud.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用API返回实体
 *
 * @author Tim
 */
@Data
@AllArgsConstructor
public class R<T> implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private T data;

    public R(String code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public R() {
        this.code = "0000";
        this.message = "成功";
        this.success = true;
    }

    public R(T data) {
        this();
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return new R<>(data);
    }

    public static <T> R<T> fail(String code, String message) {
        R<T> result = new R<>();
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(code);
        return result;
    }

    public static <T> R<T> fail(R cr) {
        R<T> result = new R<>();
        result.setSuccess(false);
        result.setMessage(cr.getMessage());
        result.setCode(cr.getCode());
        return result;
    }
}
