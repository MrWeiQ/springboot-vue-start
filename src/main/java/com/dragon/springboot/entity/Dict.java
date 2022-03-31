package com.dragon.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Mr.Wei
 * @Create: 2022-03-17 17:35
 * @Title：
 */
@TableName("sys_dict")
@Data
public class Dict {
    private String name;
    private String value;
    private String type;
}
