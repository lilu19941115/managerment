package com.common.vo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页列表参数
 */
@Data
public class PageResult<T> extends BaseEntity implements Serializable {
    private Long total;
    private List<T> records= Collections.emptyList();
    private Long pages;
    private Long current;
    private Long size;

    public PageResult() {
    }

    public PageResult(IPage page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
        this.pages=page.getPages();
        this.current=page.getCurrent();
        this.size=page.getSize();
    }
}
