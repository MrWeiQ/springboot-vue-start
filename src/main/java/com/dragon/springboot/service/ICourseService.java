package com.dragon.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragon.springboot.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dragon
 * @since 2022-03-24
 */
public interface ICourseService extends IService<Course> {
    Page<Course> findPage(Page<Course> page, String name);

    void setStudentCourse(Integer courseId, Integer studentId);
}
