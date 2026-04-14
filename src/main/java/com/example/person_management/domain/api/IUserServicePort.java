package com.example.person_management.domain.api;

import com.example.person_management.domain.model.User;

public interface IUserServicePort {

    User getUserById(Long id);
    User createUser(User user);
}
