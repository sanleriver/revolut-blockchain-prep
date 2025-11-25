package com.sanleriver.fiatservice.application.usecase;

import com.sanleriver.fiatservice.application.command.TransferMoneyCommand;
import com.sanleriver.fiatservice.domain.model.Transfer;
import com.sanleriver.fiatservice.domain.port.out.ExchangeRateProvider;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class TransferMoneyUseCase {
    private final ExchangeRateProvider rateProvider;

    public Mono<Transfer> execute(TransferMoneyCommand command){
        return rateProvider.findByCurrency(command.from())
                .zipWith(rateProvider.findByCurrency(command.to()))
                .map(tuple -> {
                    var fromRate =tuple.getT1();
                    var toRate =tuple.getT2();
                    var converted = fromRate.convertTo(command.amount(), toRate);
                    return Transfer.builder()
                            .id(UUID.randomUUID().toString())
                            .fromCurrency(command.from())
                            .toCurrency(command.to())
                            .originalAmount(command.amount())
                            .convertedAmount(converted)
                            .build();
                });
    }
}
