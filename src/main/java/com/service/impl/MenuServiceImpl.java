package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.vo.PageParam;
import com.common.vo.PageResult;
import com.dao.MenuMapper;
import com.entity.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 * 菜单业务层实现类
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    //操作成功计数标志
    private Integer res;
    @Override
    public Menu addMenu(Menu menu) {
        UUID aid= UUID.randomUUID();
        menu.setAid(aid.toString());
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
        menu.setOperation(true);
        return menu;
    }

    @Override
    public int deleteMenu(String aid) {
        try {
            res=menuMapper.deleteByPrimaryKey(aid);
        } catch (Exception e) {
            e.printStackTrace();
            res=0;
        }
        return res;
    }

    @Override
    public int updateMenu(Menu menu) {
        try {
            res=menuMapper.updateByPrimaryKeySelective(menu);
        } catch (Exception e) {
            e.printStackTrace();
            res=0;
        }
        return res;
    }

    @Override
    public Menu getMenu(String aid) {
        Menu menu;
        try {
             menu=menuMapper.selectByPrimaryKey(aid);
        } catch (Exception e) {
            e.printStackTrace();
            menu=new Menu();
            menu.setOperation(false);
        }
        return menu;
    }

    @Override
    public PageResult<Menu> getMenus(PageParam<Menu> param) {
        Menu paramter=param.getObject();
        IPage<Menu> iPage= null;
        PageResult<Menu> result;
        try {
            iPage = new Page<>(param.getPageNum(),param.getPageSize(),true);
            List<Menu> menus=menuMapper.getByParam(iPage,paramter);
            iPage.setRecords(menus);
            result=new PageResult<>(iPage);
            result.setOperation(true);
        } catch (Exception e) {
            e.printStackTrace();
            result=new PageResult<>(iPage);
            result.setOperation(false);
        }
        return result;
    }

    @Override
    public IPage<Menu> getMenusByWrapper(IPage<Menu> iPage, Wrapper<Menu> wrapper) {
        return menuMapper.selectPage(iPage,wrapper);
    }
}
