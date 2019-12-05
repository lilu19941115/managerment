package com.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.api.ApiRest;
import com.common.api.ApiResult;
import com.common.enums.ApiCode;
import com.common.vo.PageParam;
import com.common.vo.PageResult;
import com.entity.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 菜单控制器
 */
@RestController
@RequestMapping("/menu")
public class MenuRest extends ApiRest {
    @Autowired
    private MenuService menuService;

    @PostMapping
    public ApiResult<Menu> add(@RequestBody Menu menu){
        Menu result=menuService.addMenu(menu);
        if(result.getOperation()){
            return ApiResult.success(ApiCode.SUCCESS,result);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @DeleteMapping("/{aid}")
    public ApiResult delete(@PathVariable String aid){
        int res=menuService.deleteMenu(aid);
        if(res==1){
            return ApiResult.success(ApiCode.SUCCESS);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @PutMapping
    public ApiResult update(@RequestBody Menu menu){
        int res=menuService.updateMenu(menu);
        if(res==1){
            return ApiResult.success(ApiCode.SUCCESS);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @GetMapping("/{aid}")
    public ApiResult<Menu> getByAid(@PathVariable String aid){
        Menu result=menuService.getMenu(aid);
        if(result instanceof Menu&&!result.getOperation()){
        return ApiResult.fail(ApiCode.FAIAL_500);
        }
        return ApiResult.success(ApiCode.SUCCESS,result);
    }

    @GetMapping("/getList")
    public ApiResult<PageResult<Menu>> getList(@RequestBody PageParam<Menu> param){
        PageResult<Menu> result=menuService.getMenus(param);
        if(result.getOperation()){
            return ApiResult.success(ApiCode.SUCCESS,result);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @GetMapping("/getListByWapper")
    public ApiResult<PageResult<Menu>> getListByWapper(@RequestBody PageParam<Menu> param){
        Menu paramter=param.getObject();
        PageResult<Menu> pageResult= null;
        try {
            QueryWrapper<Menu> queryWrapper=new QueryWrapper<>();
            //按name 模糊查询，并且排除查询基类中的字段
            queryWrapper.like("name",paramter.getName())
                    .select(Menu.class,i->!i.getColumn().equals("code")
                                        &&!i.getColumn().equals("operation"));
            Page<Menu> page = new Page<>(param.getPageNum(),param.getPageSize());
            IPage<Menu> iPage=menuService.getMenusByWrapper(page,queryWrapper);

            pageResult = new PageResult<>(iPage);
            pageResult.setOperation(true);
        } catch (Exception e) {
            pageResult=new PageResult<>();
            pageResult.setOperation(false);
            e.printStackTrace();
        }
        if(pageResult.getOperation()){
            return ApiResult.success(ApiCode.SUCCESS,pageResult);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }
}
