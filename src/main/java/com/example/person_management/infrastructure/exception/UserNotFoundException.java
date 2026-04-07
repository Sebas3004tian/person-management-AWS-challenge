package com.example.person_management.infrastructure.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id " + id + " does not exist.");
    }
}
