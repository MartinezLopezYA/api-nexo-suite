package com.websolutions.ns.controller;

import com.websolutions.ns.dto.UserRequestDTO;
import com.websolutions.ns.dto.UserResponseDTO;
import com.websolutions.ns.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexo-suite")
@RequiredArgsConstructor
@Tag(name = "Users", description = "API to users management")
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users")
    @Operation(summary = "This Endpoint allow create a new user functionality")
    public ResponseEntity<UserResponseDTO> createUser(
            @Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @GetMapping("/v1/users")
    @Operation(summary = "This Endpoint allow list all users in database functionality")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

}
