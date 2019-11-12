package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public String show(){

        return "show";
    }

    @RequestMapping("queryuser")
    @ResponseBody
    public List<User> queryuser(){

        return userService.queryuser();
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user) {

        userService.addUser(user);

        return null;
    }

    @RequestMapping("delAll")
    @ResponseBody
    public  String delAll(Integer[] ids){
        userService.delAll(ids);
        return  null;
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(Integer userId){

        return userService.queryUserById(userId);
    }

}
