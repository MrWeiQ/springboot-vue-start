package com.dragon.springboot.controller.dto;

import com.dragon.springboot.entity.Menu;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.Wei
 * @Create: 2022-03-11 13:16
 * @Title：接受前端请求的参数
 */
@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String nickname;  //昵称
    private String avatarUrl;  //头像
    private String token;
    private String role;
    private List<Menu> menus;
}
