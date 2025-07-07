package com.websolutions.ns.controller;

import com.websolutions.ns.dto.UserRequestDTO;
import com.websolutions.ns.dto.UserResponseDTO;
import com.websolutions.ns.dto.shared.ApiSuccessResponse;
import com.websolutions.ns.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/nexo-suite")
@RequiredArgsConstructor
@Tag(name = "Users", description = "API to users management")
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users")
    @Operation(summary = "This Endpoint allow create a new user functionality")
    public ResponseEntity<ApiSuccessResponse<UserResponseDTO>> createUser(
            @Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO user = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiSuccessResponse.<UserResponseDTO>builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .message("User created successfully")
                        .data(user)
                        .build()
        );
    }

    @GetMapping("/v1/users")
    @Operation(summary = "This Endpoint allow list all users in database functionality")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/v1/users/{uuid}")
    @Operation(summary = "This Endpoint return information about user found by uuid")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(userService.getUserById(uuid));
    }

    @DeleteMapping("/v1/users/{uuid}")
    @Operation(summary = "This Endpoint allow delete a user by UUID functionality")
    public ResponseEntity<ApiSuccessResponse<Void>> deleteUser(@PathVariable UUID uuid) {
        userService.deleteUser(uuid);
        return ResponseEntity.ok(
                ApiSuccessResponse.<Void>builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .message("User deleted successfully")
                        .data(null)
                        .build()
        );
    }

}
