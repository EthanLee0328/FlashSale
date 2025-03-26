package com.lee.flashsale.controller;

import com.lee.flashsale.pojo.User;
import com.lee.flashsale.service.GoodsService;
import com.lee.flashsale.service.UserService;
import com.lee.flashsale.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    //    @Resource
//    private UserService userService;
    @Autowired
    private GoodsService goodsService;

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
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }


    //跳转商品详情页面
    @RequestMapping(value = "/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);

        //============处理秒杀倒计时和状态 start ==============
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();

//秒杀状态
        int flashsaleStatus = 0;
//秒杀倒计时
        int remainSeconds = 0;

        // 0 秒杀未开始 记录倒计时 1 秒杀开始但是未结束 秒杀进行中  2  秒杀结束了
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            flashsaleStatus = 2;
            remainSeconds = -1;
        } else {
            flashsaleStatus = 1;
        }

        model.addAttribute("flashsaleStatus", flashsaleStatus);
        model.addAttribute("remainSeconds", remainSeconds);

//============处理秒杀倒计时和状态 end ==============

        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }
}
