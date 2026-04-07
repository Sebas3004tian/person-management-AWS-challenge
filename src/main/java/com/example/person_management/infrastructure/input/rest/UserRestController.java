package com.example.person_management.infrastructure.input.rest;

import com.example.person_management.application.dto.request.CreateUserRequestDto;
import com.example.person_management.application.dto.response.UserResponseDto;
import com.example.person_management.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @GetMapping("/{id}")
    @Operation(summary = "Get the email of some user with the user Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The server has responded to the user's email."),
            @ApiResponse(responseCode = "403", description = "Access Denied"),
            @ApiResponse(responseCode = "409", description = "User not found")
    })
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userHandler.getUser(id));
    }

    @PostMapping("/")
    @Operation(summary = "Create an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "403", description = "Access Denied"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto){
        UserResponseDto userResponseDto =  userHandler.createUser(createUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
}
