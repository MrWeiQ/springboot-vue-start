package com.dragon.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Mr.Wei
 * @Create: 2022-03-14 11:23
 * @Title：文件上传实体类
 */
@Data
@TableName("sys_file")
public class Files {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;
    @TableField("name")
    private String name;
    private String type;
    private Long size;
    private String url;
    private String md5;
    @TableField("is_delete")
    private Boolean isDelete;
    private Boolean enable;

}
