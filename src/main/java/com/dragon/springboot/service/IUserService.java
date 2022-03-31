package com.dragon.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.springboot.controller.dto.UserDto;
import com.dragon.springboot.entity.User;
import com.dragon.springboot.entity.UserPasswordDTO;

public interface IUserService extends IService<User> {

    UserDto login(UserDto userDto);

    User register(UserDto userDto);

    void updatePassword(UserPasswordDTO userPasswordDTO);

    Page<User> findPage(Page<User> page, String username, String email, String address);
}
