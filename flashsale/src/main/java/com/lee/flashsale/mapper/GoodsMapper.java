package com.lee.flashsale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.flashsale.pojo.Goods;
import com.lee.flashsale.vo.GoodsVo;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    //获取商品列表
    List<GoodsVo> findGoodsVo();
}
