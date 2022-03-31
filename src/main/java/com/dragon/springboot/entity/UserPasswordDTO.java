package com.dragon.springboot.entity;

import lombok.Data;

/**
 * @author Mr.Wei
 * @Create: 2022-03-21 16:29
 * @Title：
 */
@Data
public class UserPasswordDTO {
    private String username;
    private String password;
    private String newPassword;
}
