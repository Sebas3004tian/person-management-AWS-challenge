package com.example.person_management.application.handler.impl;

import com.example.person_management.application.dto.request.CreateUserRequestDto;
import com.example.person_management.application.dto.response.UserResponseDto;
import com.example.person_management.application.handler.IUserHandler;
import com.example.person_management.application.mapper.IUserRequestMapper;
import com.example.person_management.application.mapper.IUserResponseMapper;
import com.example.person_management.domain.api.IUserServicePort;
import com.example.person_management.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public UserResponseDto getUser(Long id){
        return userResponseMapper.toResponse(userServicePort.getUserById(id));
    }

    @Override
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
        User user = userRequestMapper.toUser(createUserRequestDto);
        return userResponseMapper.toResponse(userServicePort.createUser(user));
    }

}
