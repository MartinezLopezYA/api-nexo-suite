package com.websolutions.ns.dto.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiSuccessResponse<T> {

    private HttpStatus status;
    private boolean success;
    private String message;
    private T data;

}
