package com.lee.flashsale.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;
import java.io.Serializable;

@Data
@TableName("flashsale_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户 ID,手机号码
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String nickname;
    /**
     * MD5(MD5(pass 明文+固定 salt1)+salt2)
     */
    private String password;
    private String salt;
    /**
     * 头像
     */
    private String head;
    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;
    /**
     * 登录次数
     */
    private Integer loginCount;


}
