package com.lee.flashsale.controller;


import com.lee.flashsale.service.UserService;
import com.lee.flashsale.vo.LoginVo;
import com.lee.flashsale.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";// 到 templates/login.html下
    }

    //登录功能
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin
    (@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("从客户端拿到的用户手机号和密码 {}",loginVo);
        return userService.doLogin(loginVo,request,response);
    }

}
