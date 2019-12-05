package com.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


public class BaseEntity implements Serializable {
    @Value("200")
    private Integer code;//操作状态码
    @Value("true")
    private Boolean operation;//持久层是否出现异常

    public BaseEntity(){
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getOperation() {
        return operation;
    }

    public void setOperation(Boolean operation) {
        this.operation = operation;
    }
}
