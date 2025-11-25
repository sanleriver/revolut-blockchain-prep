package com.sanleriver.fiatservice.infrastructure.entrypoints.model;

import java.math.BigDecimal;

public record TransferMoneyDTO(
        String from,
        String to,
        BigDecimal amount
) {}
