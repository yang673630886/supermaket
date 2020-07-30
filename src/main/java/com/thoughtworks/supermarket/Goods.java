package com.thoughtworks.supermarket;

import java.math.BigDecimal;

public class Goods {
    private String name;
    private BigDecimal price;
    private GoodsType goodsType;

    public Goods(String name, BigDecimal price, GoodsType goodsType) {
        this.name = name;
        this.price = price;
        this.goodsType = goodsType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public boolean notSale(GoodsType goodsType){
        return goodsType.equals(GoodsType.OTHER);
    }
}
