package com.benxinm.bookapp.mappers;

import com.benxinm.bookapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //用户登录返回用户信息
    User getUserByAccount(String account);
    //检查注册时是否有重复的账户
    int check(String account);
    //注入新的用户
    int insertUser(String account,String psd);
    //登录检查是否密码正确
    String getPsdByAccount(String account);
}
