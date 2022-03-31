package com.dragon.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Dragon
 * @since 2022-03-24
 */
@Getter
@Setter
  @ApiModel(value = "Course对象", description = "")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("课程名称")
    private String name;

    private Integer score;

    private String times;
    @ApiModelProperty("是否开课")
    private Boolean state;

    private Integer teacherId;
    @TableField(exist = false)
    private String teacher;
}
