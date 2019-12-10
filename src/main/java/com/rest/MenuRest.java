package com.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.api.ApiRest;
import com.common.api.ApiResult;
import com.common.enums.ApiCode;
import com.common.vo.PageParam;
import com.common.vo.PageResult;
import com.entity.Menu;
import com.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单控制器
 */
@RestController
@RequestMapping("/menu")
public class MenuRest extends ApiRest {
    private static final Logger LOG= LoggerFactory.getLogger(ApiRest.class);
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
        if(result.getOperation()){
            return ApiResult.success(ApiCode.SUCCESS,result);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @GetMapping("/getList")
    public ApiResult<PageResult<Menu>> getList(@RequestBody PageParam<Menu> param){
        PageResult<Menu> result=menuService.getMenus(param);
        if(result.getOperation()){
            return ApiResult.success(ApiCode.SUCCESS,result);
        }
        return ApiResult.fail(ApiCode.FAIAL_500);
    }

    @GetMapping("/getAllMenus")
    public ApiResult<List<Menu>> getAllMenus(){
        List<Menu> result=menuService.getAllMenus();
        return ApiResult.success(ApiCode.SUCCESS,result);
    }

    @GetMapping("/getListByWrapper")
    public ApiResult<PageResult<Menu>> getListByWrapper(@RequestBody PageParam<Menu> param){
        IPage<Menu> result=menuService.getMenusByWrapper(param);
        PageResult pageResult=new PageResult(result);
        return ApiResult.success(ApiCode.SUCCESS,pageResult);
    }
}
