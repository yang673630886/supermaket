package com.thoughtworks.supermarket;

import org.junit.Test;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void should_return_score_1_when_calculate_given_price_1() {
        Goods goods = new Goods("pen", BigDecimal.valueOf(1), GoodsType.OTHER);
        List<Goods> goodsList = Arrays.asList(goods);
        Calulator calulator = new Calulator();
        int result = calulator.calculatePrice(goodsList).intValue();
        assertEquals(1, result);
    }


}
