package com.websolutions.ns.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDTO {

    private UUID uuid;
    private String userEmail;
    private String userName;
    private String userPhone;
    private LocalDateTime createdAt;

}
