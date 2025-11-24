package com.sanleriver.fiatservice.domain.port.out;

import com.sanleriver.fiatservice.domain.model.ExchangeRate;
import reactor.core.publisher.Mono;

public interface ExchangeRateProvider {
    Mono<ExchangeRate> findByCurrency(String currency);
}
