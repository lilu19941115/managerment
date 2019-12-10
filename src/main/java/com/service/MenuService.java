package com.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.api.ApiService;
import com.common.vo.PageParam;
import com.common.vo.PageResult;
import com.entity.Menu;

import java.util.List;

/**
 * 菜单业务层接口类
 */
public interface MenuService extends ApiService {

    Menu addMenu(Menu menu);
    int deleteMenu(String aid);
    int updateMenu(Menu menu);
    Menu getMenu(String aid);
    PageResult<Menu> getMenus(PageParam<Menu> param);
    List<Menu>  getAllMenus();
    IPage<Menu> getMenusByWrapper(PageParam<Menu> param);
}
