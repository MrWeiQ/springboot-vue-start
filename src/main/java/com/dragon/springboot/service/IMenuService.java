package com.dragon.springboot.service;

import com.dragon.springboot.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dragon
 * @since 2022-03-16
 */
public interface IMenuService extends IService<Menu> {
    List<Menu> findMenus(String name);
}
