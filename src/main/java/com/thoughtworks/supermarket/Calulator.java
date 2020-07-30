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

    int calculateScore(BigDecimal price, List<Goods> goodsList) {
        BigDecimal score = BigDecimal.ZERO;
        Calulator calulator = new Calulator();
        BigDecimal salePrice = calulator.calculateSalePrice(goodsList);
        BigDecimal notsalePrice = calulator.calculateNotSalePrice(goodsList);
//        System.out.println("price: "+price.intValue());
//        System.out.println("salePrice: "+salePrice.intValue());
        if (price.intValue() > 1000) {
            if (salePrice.intValue() > 1000) {
                score = BigDecimal.valueOf(2000).add(salePrice).subtract(BigDecimal.valueOf(1000)).add(notsalePrice.divide(BigDecimal.valueOf(20)));
            } else {
                score = salePrice.multiply(BigDecimal.valueOf(2));
                score = score.add(BigDecimal.valueOf(1000-salePrice.intValue())).
                        add((notsalePrice.subtract(BigDecimal.valueOf(1000-salePrice.intValue())).divide(BigDecimal.valueOf(20))));
            }
        }else
            for (Goods goods : goodsList
            ) {
                if (goods.notSale(goods.getGoodsType())) {
                    score = score.add(goods.getPrice());
                } else {
                    score = score.add(goods.getPrice());
                    score = score.add(goods.getPrice());
                }
            }
        return score.intValue();
    }
}
