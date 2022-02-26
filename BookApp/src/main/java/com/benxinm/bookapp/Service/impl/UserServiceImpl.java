package com.benxinm.bookapp.Service.impl;

import com.benxinm.bookapp.Service.UserService;
import com.benxinm.bookapp.entity.User;
import com.benxinm.bookapp.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User getByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public boolean checkExist(String account) {
        return userMapper.check(account)>0? false:true;
    }

    @Override
    public int insertUser( String account, String psd) {
        return userMapper.insertUser(account,psd);
    }

    @Override
    public Boolean getPsd(String account,String providedPsd) {
        return userMapper.getPsdByAccount(account).equals(DigestUtils.md5DigestAsHex(providedPsd.getBytes()));
    }
}
