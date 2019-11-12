package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.UserModelMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserModelMapper userModelMapper;


    @Override
    public User queryUserByName(String username) {
        return userModelMapper.queryUserByName(username);
    }




}
