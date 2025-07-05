package com.websolutions.ns.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    @Size(min = 2, max = 50)
    private String userName;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$")
    private String userPhone;

}
