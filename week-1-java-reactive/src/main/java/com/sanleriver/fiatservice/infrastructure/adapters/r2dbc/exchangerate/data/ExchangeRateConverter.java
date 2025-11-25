package com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate.data;

import com.sanleriver.fiatservice.domain.model.ExchangeRate;

public class ExchangeRateConverter {
    public ExchangeRate toModel(ExchangeRateEntity entity){
        return ExchangeRate.builder()
                .currency(entity.currency())
                .rate(entity.rate())
                .build();
    }
}
