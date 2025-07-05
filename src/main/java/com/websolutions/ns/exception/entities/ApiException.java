package com.websolutions.ns.exception.entities;


import com.websolutions.ns.util.ErrorCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final String errorCode;
    private final HttpStatus httpStatus;

    public ApiException(String message, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

}
