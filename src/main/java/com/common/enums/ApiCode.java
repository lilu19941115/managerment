package com.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ApiCode {
    SUCCESS(200,"操作成功"),
    FAIAL_500(500,"服务器发生错误");
    private Integer code;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
