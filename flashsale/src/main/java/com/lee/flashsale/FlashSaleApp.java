package com.lee.flashsale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lee.flashsale.mapper")
public class FlashSaleApp {
    public static void main(String[] args) {
        SpringApplication.run(FlashSaleApp.class, args);
    }
}
