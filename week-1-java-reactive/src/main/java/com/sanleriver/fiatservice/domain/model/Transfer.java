package com.sanleriver.fiatservice.domain.model;

import java.math.BigDecimal;

public record Transfer(
        String fromCurrency,
        String toCurrency,
        BigDecimal originalAmount,
        BigDecimal convertedAmount,
        String id) {

}
