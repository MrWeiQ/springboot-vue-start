package com.dragon.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragon.springboot.entity.User;
import com.dragon.springboot.entity.UserPasswordDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

    Page<User> findPage(Page<User> page, @Param("username") String username, @Param("email") String email, @Param("address") String address);


    /* @Select("select * from sys_user")
    List<User> selectAll();
    @Insert("Insert into sys_user(username,password,nickname,email,phone,address) " +
            "values (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

*//*    @Update("update sys_user set username=#{username},password=#{password},nickname=#{nickname}," +
            "email=#{email},phone=#{phone},address=#{address} where id = #{id}")*//*
    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);//@Param(这里的值)和#{这里的值}一致

    @Select("select * from sys_user where username like #{username} and email like #{email} and address like #{address} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String username,String email,String address);

    @Select("select count(*) from sys_user where username like concat('%', #{username}, '%') ")
    Integer selectTotal(String username);*/
}
