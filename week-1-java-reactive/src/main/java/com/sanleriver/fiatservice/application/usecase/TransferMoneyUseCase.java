package com.sanleriver.fiatservice.application.usecase;

import com.sanleriver.fiatservice.application.command.TransferMoneyCommand;
import com.sanleriver.fiatservice.domain.model.Transfer;
import com.sanleriver.fiatservice.domain.port.out.ExchangeRateProvider;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TransferMoneyUseCase {
    private final ExchangeRateProvider rateProvider;

    public Mono<Transfer> execute(TransferMoneyCommand command){
        return null;
    }
}
