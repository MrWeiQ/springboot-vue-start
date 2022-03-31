package com.dragon.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Wei
 * @Create: 2022-03-03 15:03
 * @Title： 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
@ToString
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("username") //数据库中字段
    private String username;
    @JsonIgnore  //忽略不显示
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

    private Date createTime;

    private String avatarUrl;
    private String role;

    @TableField(exist = false)
    private List<Course> courses;
    @TableField(exist = false)
    private List<Course> stuCourses;
}