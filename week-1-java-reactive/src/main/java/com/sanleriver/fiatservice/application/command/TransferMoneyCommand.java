package com.sanleriver.fiatservice.application.command;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransferMoneyCommand(
        String from,
        String to,
        BigDecimal amount
) {}
