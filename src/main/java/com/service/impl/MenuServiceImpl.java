package com.service.impl;

import com.common.vo.PageParam;
import com.common.vo.PageResult;
import com.dao.MenuMapper;
import com.entity.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单业务层实现类
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu addMenu(Menu menu) {
        int res= 0;
        try {
            res = menuMapper.insertSelective(menu);
            if(res!=1){
                menu.setOperation(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            menu.setOperation(false);
            menu.setCode(500);
        }

        return menu;
    }

    @Override
    public int deleteMenu(String aid) {
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        return 0;
    }

    @Override
    public Menu getMenu(String aid) {
        return null;
    }

    @Override
    public PageResult<Menu> getMenus(PageParam<Menu> param) {
        return null;
    }
}
