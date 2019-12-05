package com.common.vo;

import lombok.Data;

/**
 * 分页参数
 */
@Data
public class PageParam<T> {
    private Integer pageSize;
    private Integer pageNum;
    private T  object;
    private String sortBy;
    private String order;
}
