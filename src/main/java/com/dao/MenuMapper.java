package com.dao;

import com.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(String aid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}