package com.entity;

import com.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * 用户类
 */
@Data
@Builder
public class User extends BaseEntity {
    private String aid;
    private String account;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Integer sex;
    private String remark;
    @Tolerate
    public User (){}
}
