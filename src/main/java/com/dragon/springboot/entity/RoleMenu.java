package com.dragon.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Mr.Wei
 * @Create: 2022-03-18 14:35
 * @Title：
 */
@TableName("sys_role_menu")
@Data
public class RoleMenu {
    private Integer roleId;
    private Integer menuId;
}
