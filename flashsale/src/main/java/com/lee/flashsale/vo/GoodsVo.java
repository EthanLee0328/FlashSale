package com.lee.flashsale.vo;

import com.lee.flashsale.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    private BigDecimal flashsalePrice;
    private Integer flashsaleStockCount;
    private Date startDate;
    private Date endDate;
}