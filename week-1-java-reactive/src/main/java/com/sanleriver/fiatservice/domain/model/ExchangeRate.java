package com.sanleriver.fiatservice.domain.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
public record ExchangeRate(String currency, BigDecimal rate) {
    public BigDecimal convertTo(BigDecimal amount, ExchangeRate target){
        return amount.multiply(this.rate).divide(target.rate, 6, RoundingMode.HALF_UP);
    }
}
