package com.lee.flashsale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.flashsale.exception.GlobalException;
import com.lee.flashsale.mapper.UserMapper;
import com.lee.flashsale.pojo.User;
import com.lee.flashsale.service.UserService;
import com.lee.flashsale.util.CookieUtil;
import com.lee.flashsale.util.MD5Util;
import com.lee.flashsale.util.UUIDUtil;
import com.lee.flashsale.util.ValidatorUtil;
import com.lee.flashsale.vo.LoginVo;
import com.lee.flashsale.vo.RespBean;
import com.lee.flashsale.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
//判断是否为空 参数校验
//        if (!StringUtils.hasText(mobile)
//                || !StringUtils.hasText(password)) {
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//手机校验
//        if (!ValidatorUtil.isMobile(mobile)) {
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        // 在类LoginVo中有注解呀 所以上面2个方法不用写了
//查询数据库
        log.info("数据库查询之前操作正常");
        User user = userMapper.selectById(mobile);
        log.info("user:->{}", user);
        if (user == null) {
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);//抛异常让全局处理
        }
        if (!MD5Util.midPasswordToDBPassword(password, user.getSalt()).equals(user.getPassword())) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        // todo 走到这 就说明 用户登录成功了
        String ticket = UUIDUtil.uuid();
//        request.getSession().setAttribute(ticket, user);
        //为了实现分布式 session,把 session 放在 redis 里面
        redisTemplate.opsForValue().set("user:" + ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {

        if(!StringUtils.hasText(userTicket)){
            return null;
        }
        User user =(User) redisTemplate.opsForValue().get("user:" + userTicket);
//如果用户不为 null,重新设置 cookie
        if(user != null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }


}
