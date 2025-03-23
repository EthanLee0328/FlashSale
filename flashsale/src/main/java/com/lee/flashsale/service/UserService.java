package com.lee.flashsale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.flashsale.pojo.User;
import com.lee.flashsale.vo.LoginVo;
import com.lee.flashsale.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService extends IService<User> {
    RespBean doLogin(LoginVo loginVo,
                     HttpServletRequest request,
                     HttpServletResponse response);

    //根据 cookie 获取用户
    User getUserByCookie
    (String userTicket,HttpServletRequest request, HttpServletResponse response);
}
