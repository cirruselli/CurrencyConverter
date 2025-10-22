package com.wigell.grupp4.currencyConverter.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ExchangeRates {
    private final BigDecimal USD = new BigDecimal("0.11");
    private final BigDecimal GBP = new BigDecimal("0.079");
    private final BigDecimal PLN = new BigDecimal("0.39");
    private final BigDecimal JPY = new BigDecimal("15.94");

    public BigDecimal getUSD() {
        return USD;
    }

    public BigDecimal getGBP() {
        return GBP;
    }

    public BigDecimal getPLN() {
        return PLN;
    }

    public BigDecimal getJPY() {
        return JPY;
    }

    public int getROUND_OFF_SCALE() {
        //för öre eller pennies i gbp
        return 2;
    }
}
