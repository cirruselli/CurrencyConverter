package com.wigell.grupp4.currencyConverter.service;

import com.wigell.grupp4.currencyConverter.util.ExchangeRates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateService {
    private final ExchangeRates exchangeRates;
    public ExchangeRateService(ExchangeRates exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public BigDecimal toUSD(BigDecimal sek) {
        return convertToCurrency(sek, exchangeRates.getUSD());
    }

    public BigDecimal toGBP(BigDecimal gbp) {
        return convertToCurrency(gbp, exchangeRates.getGBP());
    }

    public BigDecimal toPLN(BigDecimal pln) {
        return convertToCurrency(pln, exchangeRates.getPLN());
    }

    public BigDecimal toJPY(BigDecimal jpy) {
        return convertToCurrency(jpy, exchangeRates.getJPY());
    }

    private BigDecimal convertToCurrency(BigDecimal amount, BigDecimal rate) {
        return amount.multiply(rate).setScale(exchangeRates.getROUND_OFF_SCALE(), RoundingMode.HALF_UP);
    }
}
