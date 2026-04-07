package com.example.person_management.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private Long identificationNumber;
    private String name;
    private String email;
}
