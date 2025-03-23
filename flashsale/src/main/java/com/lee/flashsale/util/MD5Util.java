package com.lee.flashsale.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    // 1 生成md5
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    // 2 随机生成SALT https://suijimimashengcheng.bmcx.com/
    public static final String SALT = "5BQ5EZru";

    //3 md5+salt 生成中间密码
    public static String inputPasswordToMidPassword(String inputPassword) {
        // 可以 diy
        return md5(SALT.charAt(0) + inputPassword + SALT.charAt(6));
    }

    //4 对生成的中间密码即inputPasswordToMidPassword 再次加salt 然后md5 生成对应的db的密码
    public static String midPasswordToDBPassword(String midPassword, String salt) {
        return md5(salt.charAt(1) + midPassword + salt.charAt(7));
    }

    // 5 直接生成 DB密码 即 md5(md5(inputPassword+salt1)+salt2)
    public static String inputPasswordToDBPassword(String inputPassword, String salt) {
        return midPasswordToDBPassword(inputPasswordToMidPassword(inputPassword), salt);
    }

}
