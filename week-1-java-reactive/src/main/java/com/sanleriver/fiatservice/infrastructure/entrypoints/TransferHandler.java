package com.sanleriver.fiatservice.infrastructure.entrypoints;

import com.sanleriver.fiatservice.application.command.TransferMoneyCommand;
import com.sanleriver.fiatservice.application.usecase.TransferMoneyUseCase;
import com.sanleriver.fiatservice.infrastructure.entrypoints.model.TransferMoneyDTO;
import com.sanleriver.fiatservice.infrastructure.entrypoints.model.mapper.TransferRestMapper;
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
    private static final TransferRestMapper mapper = new TransferRestMapper();

    public Mono<ServerResponse> convert(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(TransferMoneyDTO.class)
                .map(mapper::toDomain)
                .flatMap(useCase::execute)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }
}
