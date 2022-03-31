package com.dragon.springboot.config;

import java.lang.annotation.*;

//自定义注解，当拦截器看到这个接口上的注解就放行
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthAccess {

}
