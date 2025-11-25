package com.sanleriver.fiatservice.infrastructure.config;

import com.sanleriver.fiatservice.application.usecase.TransferMoneyUseCase;
import com.sanleriver.fiatservice.domain.port.out.ExchangeRateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public TransferMoneyUseCase transferMoneyUseCase(ExchangeRateProvider provider) {
        return new TransferMoneyUseCase(provider);
    }
}
