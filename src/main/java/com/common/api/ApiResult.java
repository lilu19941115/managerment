package com.common.api;

import com.common.enums.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * api接口返回基类
 */
@Data
@Builder
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    private String msg;
    private Integer code;
    private T object;

    /**
     * 成功返回
     * @param apiCode
     * @param result
     * @return
     */
    public  static ApiResult success(ApiCode apiCode,Object result){
         return ApiResult.builder().code(apiCode.getCode()).msg(apiCode.getMsg()).object(result).build();
    }

    /**
     *
     * @param apiCode
     * @return
     */
    public  static ApiResult success(ApiCode apiCode){
        return ApiResult.builder().code(apiCode.getCode()).msg(apiCode.getMsg()).build();
    }

    public static ApiResult fail(ApiCode apiCode){
        return ApiResult.builder().code(apiCode.getCode()).msg(apiCode.getMsg()).build();
    }

}
