package com.websolutions.ns.exception.entities;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String resourceName, String identifier) {
        super(resourceName + " with ID " + identifier + " not found", "NOT_FOUND", HttpStatus.NOT_FOUND);
    }
}
