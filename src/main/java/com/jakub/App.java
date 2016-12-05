package com.jakub;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class App {
    public static void main(String[] args) {

        int n = 7;
        int precision = 20 + n;
        String form = "%." + n + "f\n";

        BigDecimal e = BigDecimal.ZERO;
        for (int k = 0; k < n; k++) {
            BigDecimal a0 = new BigDecimal(16).pow(k);
            BigDecimal a1 = new BigDecimal(4).divide(new BigDecimal(8 * k + 1), precision, RoundingMode.HALF_UP);
            BigDecimal a2 = new BigDecimal(2).divide(new BigDecimal(8 * k + 4), precision, RoundingMode.HALF_UP);
            BigDecimal a3 = new BigDecimal(1).divide(new BigDecimal(8 * k + 5), precision, RoundingMode.HALF_UP);
            BigDecimal a4 = new BigDecimal(1).divide(new BigDecimal(8 * k + 6), precision, RoundingMode.HALF_UP);
            BigDecimal a5 = a1.subtract(a2).subtract(a3).subtract(a4);
            BigDecimal a6 = BigDecimal.ONE.divide(a0, precision, RoundingMode.HALF_UP);

            e = e.add(a5.multiply(a6));
            System.out.printf(form, e);


        }


    }
}


