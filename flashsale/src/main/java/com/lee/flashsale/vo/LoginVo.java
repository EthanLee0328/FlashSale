package com.lee.flashsale.vo;

import com.lee.flashsale.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

//登录参数
@Data
public class LoginVo {
    @NotNull
    @IsMobile //自拟定注解
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;
}

