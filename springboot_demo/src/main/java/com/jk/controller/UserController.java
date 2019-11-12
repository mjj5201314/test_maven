package com.jk.controller;


import com.jk.model.MenuTree;
import com.jk.model.PowerModel;
import com.jk.model.RoeModel;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public String show(){

        return "show";
    }

    @RequestMapping("tologin")
    public String login(){

        return "login";
    }

    @RequestMapping("index")
    public String index(){

        return "index";
    }

    @RequestMapping("list")
    public String list(){

        return "list";
    }



    @RequestMapping("getsync")
    @ResponseBody
    public List<MenuTree> getsync(HttpSession session){

        return userService.getsync(session);
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

    @RequestMapping("queryRole")
    @ResponseBody
    public List<RoeModel> queryRole() {
        return userService.queryRole();
    }


    @RequestMapping("initPowerTree")
    @ResponseBody
    public List<MenuTree> initPowerTree(Integer roleid){

        return userService.initPowerTree(roleid);
    }

    @RequestMapping("queryMenu")
    @ResponseBody
    public List<PowerModel> queryMenu(Integer powerid){

        return userService.queryMenu(powerid);
    }

    @RequestMapping("updatePowerById")
    @ResponseBody
    public void updatePowerById(MenuTree power){
        userService.updatePowerById(power);
    }

    @RequestMapping("saveRolePower")
    @ResponseBody
    public void saveRolePower(Integer roleid,String[] ids){
        userService.saveRolePower(roleid,ids);
    }


    @RequestMapping("deletePowerById")
    @ResponseBody
    public void deletePowerById(Integer powerid) {
        userService.deletePowerById(powerid);
    }



    @RequestMapping("login")
    @ResponseBody
    public String login(User user,  HttpSession session) {


        String loginnumber = user.getLoginnumber();
        User user1=userService.queryUsername(loginnumber);

        if(user1==null) {
            return "用户名不存在";

        }
        if(!user.getPassword().equals(user1.getPassword())) {
            return "密码错误";
        }
        session.setAttribute("user", user1);
        return "登录成功";


    }



}
