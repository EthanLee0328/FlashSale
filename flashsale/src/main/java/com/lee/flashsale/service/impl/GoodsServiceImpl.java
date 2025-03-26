package com.lee.flashsale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.flashsale.mapper.GoodsMapper;
import com.lee.flashsale.pojo.Goods;
import com.lee.flashsale.vo.GoodsVo;
import com.lee.flashsale.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl
        extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    //获取商品列表
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    //获取商品详情
    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}
