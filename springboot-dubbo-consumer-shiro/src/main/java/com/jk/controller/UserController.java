package com.jk.controller;


import com.jk.model.User;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    @Reference
    private UserService userService;

    @RequestMapping("index")
    public  String index(){
        return "index";
    }

    @RequestMapping("login")
    public  String login(){
        return  "login2";
    }

    //登录
    @RequestMapping("querylogin")


    public String querylogin(HttpServletRequest request, Model model){
        String shiroLoginFailure = request.getAttribute("shiroLoginFailure").toString();

        if(UnknownAccountException.class.getName().equals(shiroLoginFailure) || AuthenticationException.class.getName().equals(shiroLoginFailure)){
            model.addAttribute("msg","用户名输入错误 UnknownAccountException");
        }else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)){
            model.addAttribute("msg","用户名输入错误 IncorrectCredentialsException");
        }

        return "login2";
    }
}
