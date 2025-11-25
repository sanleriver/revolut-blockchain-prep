package com.sanleriver.fiatservice.infrastructure.config;

import com.sanleriver.fiatservice.domain.port.out.ExchangeRateProvider;
import com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate.ExchangeRateRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Configuration
public class AdapterConfig {

    @Bean
    public ExchangeRateProvider exchangeRateProvider(R2dbcEntityTemplate template) {
        return new ExchangeRateRepository(template);
    }
}
