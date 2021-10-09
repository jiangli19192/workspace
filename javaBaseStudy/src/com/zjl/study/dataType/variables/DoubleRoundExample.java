package com.zjl.study.dataType.variables;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleRoundExample {

    @Test
    public void DoubleRound_BigDecimal_ROUND_HALF_UP_Example() {
        System.out.println(new BigDecimal(995.330457D).setScale(2, BigDecimal.ROUND_HALF_UP));
        // Result: 995.33
    }

    @Test
    public void DoubleRound_BigDecimal_ROUND_DOWN_Example() {
        System.out.println(new BigDecimal(995.330457D).setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
        // Result: 995.33
    }


    @Test
    public void DoubleRound_RoundingMode_CEILING_Example() {
        System.out.println(new BigDecimal(995.330457D).setScale(2, RoundingMode.CEILING).doubleValue());
        // Result: 995.34
    }

    @Test
    public void DoubleRound_RoundingMode_HALF_UP_Example() {
        System.out.println(new BigDecimal(995.330457D).setScale(2, RoundingMode.HALF_UP).doubleValue());
        // Result: 995.33
    }
}