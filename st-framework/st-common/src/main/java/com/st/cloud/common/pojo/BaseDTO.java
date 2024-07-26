package com.st.cloud.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDTO implements Serializable {
    private String domain;
    private String version;
    private String token;
}
