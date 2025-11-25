package com.sanleriver.fiatservice.infrastructure.entrypoints.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferMoneyDTO(
        String from,
        String to,
        BigDecimal amount
) {}
