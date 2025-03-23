package com.lee.flashsale.util;

import java.util.UUID;

public class UUIDUtil {
    public static String uuid() {
//把 UUID 中的- 替换掉
        return UUID.randomUUID().toString().replace("-", "");
    }
}
