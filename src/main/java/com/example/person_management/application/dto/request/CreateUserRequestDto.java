package com.example.person_management.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {

    @NotNull(message="The identificationNumber cannot be empty")
    @Positive(message="The identificationNumber cannot be negative")
    private Long identificationNumber;

    @NotBlank(message="The name cannot be empty")
    private String name;

    @NotBlank(message="The email cannot be empty")
    @Email(message="It must be in the format @example.com")
    private String email;
}
