package com.dragon.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.springboot.entity.User;
import com.dragon.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Wei
 * @Create: 2022-03-04 11:05
 * @Title：
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
        /*if (user.getId() == null){ //user没有id表示是新增
            return save(user);//mybatis-plus提供的方法，表示插入数据
        }else {  //否则为更新
            return updateById(user);
        }*/
        return saveOrUpdate(user);
    }


   /* @Autowired
    private UserMapper userMapper;

    public int insert(User user){
        if (user.getId() == null){ //user没有id表示是新增
            return userMapper.insert(user);
        }else {  //否则为更新
            return userMapper.update(user);
        }
    }
*/
}
