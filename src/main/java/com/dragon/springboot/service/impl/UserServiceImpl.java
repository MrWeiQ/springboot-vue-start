package com.dragon.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.springboot.common.Constants;
import com.dragon.springboot.controller.dto.UserDto;
import com.dragon.springboot.entity.Menu;
import com.dragon.springboot.entity.User;
import com.dragon.springboot.entity.UserPasswordDTO;
import com.dragon.springboot.exception.ServiceException;
import com.dragon.springboot.mapper.RoleMapper;
import com.dragon.springboot.mapper.RoleMenuMapper;
import com.dragon.springboot.mapper.UserMapper;
import com.dragon.springboot.service.IMenuService;
import com.dragon.springboot.service.IUserService;
import com.dragon.springboot.utils.TokenUtils;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Wei
 * @Create: 2022-03-11 14:39
 * @Title：服务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private IMenuService menuService;
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto login(UserDto userDto) {
        User one = getUserInfo(userDto);
        if (one != null) {
            BeanUtil.copyProperties(one,userDto,true);
            //设置token
            String token = TokenUtils.getToken(one.getId().toString(), one.getPassword());
            userDto.setToken(token);

            String role = one.getRole();
            //设置用户的菜单列表
            List<Menu> roleMenus = getRoleMenus(role);
            userDto.setMenus(roleMenus);
            return userDto;
        }else{
            throw new ServiceException(Constants.CODE_600,"用户名或者密码错误");
        }
    }

    /**
     * 获取当前角色的菜单列表
     * @param roleFlag
     * @return
     */
    public List<Menu> getRoleMenus(String roleFlag){
        Integer roleId = roleMapper.selectByFlag(roleFlag);
        //当前角色的所有菜单id集合
        List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);

        //查出系统所有的菜单
        List<Menu> menus = menuService.findMenus("");
        //new 一个最后筛选完成之后的list
        List<Menu> roleMenus = new ArrayList<>();
        //筛选当前所有用户
        for (Menu menu : menus) {
            if (menuIds.contains(menu.getId())) {
                roleMenus.add(menu);
            }
            List<Menu> children = menu.getChildren();
            //removeIf 移除children 里面不在menuIds集合中的元素 if条件!menuIds.contains(child.getId()
            children.removeIf(child -> !menuIds.contains(child.getId()));
        }
        return roleMenus;
    }

    @Override
    public User register(UserDto userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

    @Override
    public Page<User> findPage(Page<User> page, String username, String email, String address) {
        return userMapper.findPage(page,username,email,address);
    }

    private User getUserInfo(UserDto userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}
