package com.thoughtworks.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Calulator {
    BigDecimal calculatePrice(List<Goods> goodsList) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Goods goods : goodsList
        ) {
            sum = sum.add(goods.getPrice());
        }
        return sum;
    }

    BigDecimal calculateSalePrice(List<Goods> goodsList) {
        BigDecimal saleprice = BigDecimal.ZERO;
        for (Goods goods : goodsList) {
            if (!goods.notSale(goods.getGoodsType())) {
                saleprice = saleprice.add(goods.getPrice());
            }
        }
        return saleprice;
    }

    BigDecimal calculateNotSalePrice(List<Goods> goodsList) {
        BigDecimal notsaleprice = BigDecimal.ZERO;
        for (Goods goods : goodsList) {
            if (goods.notSale(goods.getGoodsType())) {
                notsaleprice = notsaleprice.add(goods.getPrice());
            }
        }
        return notsaleprice;

    }

}
