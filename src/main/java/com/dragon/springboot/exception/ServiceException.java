package com.dragon.springboot.exception;

import lombok.Getter;

/**
 * @author Mr.Wei
 * @Create: 2022-03-12 11:46
 * @Title：自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
