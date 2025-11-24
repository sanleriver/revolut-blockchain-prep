package com.sanleriver.fiatservice.application.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferMoneyCommand(
        @NotBlank String from,
        @NotBlank String to,
        @Positive BigDecimal amount
) {
}
