package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryuser() {

        return userMapper.queryuser();
    }

    public void addUser(User user) {
        Integer userid = user.getUserid();
        if(userid!=null){
            userMapper.updateuser(user);
        }else{
            userMapper.addUser(user);
        }

    }

    @Override
    public void delAll(Integer[] ids) {
        userMapper.delAll(ids);
    }

    @Override
    public User queryUserById(Integer userId) {

        return userMapper.queryuserByid(userId);
    }




}
