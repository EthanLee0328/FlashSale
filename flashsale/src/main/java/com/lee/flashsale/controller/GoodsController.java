package com.lee.flashsale.controller;

import com.lee.flashsale.pojo.User;
import com.lee.flashsale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
//    @Resource
//    private UserService userService;

    @RequestMapping(value = "/toList")
//    public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket) {
//    public String toList(Model model, @CookieValue("userTicket") String ticket, HttpServletRequest request, HttpServletResponse response){
    public String toList(Model model, User user) {
////如果 cookie 没有生成
//        if (!StringUtils.hasText(ticket)) {
//            return "login";
//        }
////        User user = (User) session.getAttribute(ticket);
//        //重新从 redis 获取用户信息
//        User user = userService.getUserByCookie(ticket, request, response);
        // todo 用解析器
//如果用户没有登录 todo 解析器 直接把值返回到参数上 其实也就是执行这个方法的时候 先执行解析器
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
