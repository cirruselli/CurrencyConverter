package com.wigell.grupp4.currencyConverter.controller;

import com.wigell.grupp4.currencyConverter.service.ExchangeRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/usd")
    public ResponseEntity<BigDecimal> getSekToUsdRate(@RequestParam BigDecimal sek) {
        return toResponse(exchangeRateService.toUSD(sek));
    }

    @GetMapping("/gbp")
    public ResponseEntity<BigDecimal> getSekToGbpRate(@RequestParam BigDecimal gbp) {
        return toResponse(exchangeRateService.toGBP(gbp));
    }

    @GetMapping("/pln")
    public ResponseEntity<BigDecimal> getSekToPln(@RequestParam BigDecimal pln) {
        return toResponse(exchangeRateService.toPLN(pln));
    }

    @GetMapping("/jpy")
    public ResponseEntity<BigDecimal> getSekToJpy(@RequestParam BigDecimal jpy) {
        return toResponse(exchangeRateService.toJPY(jpy));
    }

    private ResponseEntity<BigDecimal> toResponse(BigDecimal amount) {
        return new ResponseEntity<>(amount, HttpStatus.OK);
    }
}
