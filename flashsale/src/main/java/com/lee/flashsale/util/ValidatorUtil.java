package com.lee.flashsale.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    //手机号校验
    private static final Pattern mobile_pattern = Pattern.compile("^[1][3-9][0-9]{9}$");

    public static boolean isMobile(String mobile) {
        if (!StringUtils.hasText(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();//返回校验结果 true 为正确}
    }
}
