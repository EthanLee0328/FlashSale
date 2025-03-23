package com.lee.flashsale.util;

import org.junit.jupiter.api.Test;


public class MD5UtilTest {
    @Test
    public void f1(){
        System.out.println(MD5Util.inputPasswordToDBPassword("ethan1993Aa.", "oe7Y2HQg"));
        System.out.println(MD5Util.inputPasswordToMidPassword("ethan1993Aa."));
        // 7996385936ef8fbe78261157513afc9f
        System.out.println(MD5Util.midPasswordToDBPassword("e5b6db271691c14b36bbd00b7ccc9d60","oe7Y2HQg0"));
    }


}
