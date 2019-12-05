package com.entity;

import com.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * 菜单类
 */
@Data
@Builder
public class Menu extends BaseEntity {
    private String  aid;
    private Integer parentId;
    private String  name;
    private String  url;
    private String  icon;
    private String status;
    @Tolerate
    public Menu(){
    }
}
