package com.brixterporras.checkboard.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // ✅ Automatically sets 404 status
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}