package com.websolutions.ns.exception.entities;

import org.springframework.http.HttpStatus;

public class BusinessException extends ApiException {
    public BusinessException(String message, String errorCode) {
        super(message, errorCode, HttpStatus.BAD_REQUEST);
    }
}