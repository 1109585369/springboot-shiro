package com.yy.demo.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yy
 * @ProjectName springboot-shiro
 * @Description: TODO
 * @date 2019/6/11 15:23
 */
@RestController
public class LoginController {

    @PostMapping("/doLogin")
    public void doLogin(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(userName, password));
            System.out.println("登录成功");
        }catch (AuthenticationException e){
            System.out.println("登录失败");
            e.printStackTrace();
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login")
    public String login(){
        return "please login!";
    }

}
