package com.sanleriver.fiatservice.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Transfer(
        String fromCurrency,
        String toCurrency,
        BigDecimal originalAmount,
        BigDecimal convertedAmount,
        String id) {

}
