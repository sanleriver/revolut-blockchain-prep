package com.sanleriver.fiatservice.infrastructure.entrypoints;

import com.sanleriver.fiatservice.application.command.TransferMoneyCommand;
import com.sanleriver.fiatservice.application.usecase.TransferMoneyUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TransferHandler {
    private final TransferMoneyUseCase useCase;

    public Mono<ServerResponse> convert(ServerRequest serverRequest) {
        //TODO falta aquí agregar un modelo DTO para la Request y un converter al Command
        return serverRequest.bodyToMono(TransferMoneyCommand.class)
                .doOnNext(this::validate)
                .flatMap(useCase::execute)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    private void validate(@Valid TransferMoneyCommand command) {}
}
