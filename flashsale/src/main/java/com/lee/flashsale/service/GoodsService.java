package com.lee.flashsale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.flashsale.pojo.Goods;
import com.lee.flashsale.vo.GoodsVo;

import java.util.List;

public interface GoodsService extends IService<Goods> {
    //商品列表
    List<GoodsVo> findGoodsVo();
}