package com.sanleriver.fiatservice.domain.exception;

public class UnknownCurrencyException extends RuntimeException {
    public UnknownCurrencyException(String currency) {
        super("Unknown currency: "+currency);
    }
}
