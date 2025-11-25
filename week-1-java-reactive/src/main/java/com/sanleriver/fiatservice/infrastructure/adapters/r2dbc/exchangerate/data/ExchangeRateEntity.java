package com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("exchange_rates")
public record ExchangeRateEntity(
   @Id String currency,
   BigDecimal rate
) {}
