package com.example.person_management.application.handler;

import com.example.person_management.application.dto.request.CreateUserRequestDto;
import com.example.person_management.application.dto.response.UserResponseDto;

public interface IUserHandler {
    UserResponseDto getUser(Long id);
    UserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
}
