package com.dragon.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragon.springboot.common.Constants;
import com.dragon.springboot.entity.Dict;
import com.dragon.springboot.entity.Role;
import com.dragon.springboot.mapper.DictMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.Api;
import com.dragon.springboot.common.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.dragon.springboot.service.IMenuService;
import com.dragon.springboot.entity.Menu;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dragon
 * @since 2022-03-16
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    
    @Resource
    private IMenuService menuService;

    @Resource
    private DictMapper dictMapper;

    // 新增或者更新
    @PostMapping("/insert")
    public Result save(@RequestBody Menu menu) {
       return Result.success(menuService.saveOrUpdate(menu));
        }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(menuService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(menuService.removeByIds(ids));
    }

    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "") String name) {
        return Result.success(menuService.findMenus(name));
    }
    @GetMapping("/ids")
    public Result findAllIds() {
        return Result.success(menuService.list().stream().map(Menu::getId));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(menuService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage (@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByAsc("id");
        return Result.success(menuService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/icons")
    public Result getIcons() {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", Constants.DICT_TYPE_ICON);
        return Result.success(dictMapper.selectList(null));
    }
}

