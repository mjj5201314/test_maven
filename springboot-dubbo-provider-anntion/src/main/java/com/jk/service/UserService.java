package com.jk.service;

import com.jk.model.User;

import java.util.List;

public interface UserService {
    List<User> queryuser();

    void addUser(User user);

    void delAll(Integer[] ids);

    User queryUserById(Integer userId);

    void addUSers(List<User> list);
}
