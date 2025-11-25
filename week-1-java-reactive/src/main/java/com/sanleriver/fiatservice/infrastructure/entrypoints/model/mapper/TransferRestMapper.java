package com.sanleriver.fiatservice.infrastructure.entrypoints.model.mapper;

import com.sanleriver.fiatservice.application.command.TransferMoneyCommand;
import com.sanleriver.fiatservice.infrastructure.entrypoints.model.TransferMoneyDTO;
import jakarta.validation.ValidationException;

import static io.micrometer.common.util.StringUtils.isBlank;

public class TransferRestMapper {

    public TransferMoneyCommand toDomain(TransferMoneyDTO dto){
        validateDto(dto);
        return TransferMoneyCommand.builder()
                .from(dto.from())
                .to(dto.to())
                .amount(dto.amount())
                .build();
    }

    private void validateDto(TransferMoneyDTO dto) {
        if (isBlank(dto.from()) || isBlank(dto.to())) {
            throw new ValidationException("Parameters from and to are required");
        }
        if (dto.amount().signum() != 1) {
            throw new ValidationException("Parameter amount must be positive a mora than 0");
        }
    }
}
