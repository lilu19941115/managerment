package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.api.ApiMapper;
import com.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    int deleteByPrimaryKey(String aid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getByParam(IPage<Menu> page, @Param("param")Menu menu);

}