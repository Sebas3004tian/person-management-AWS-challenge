package com.example.person_management.domain.spi;

import com.example.person_management.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {

    Optional<User> findOneById(Long id);
    User createUser(User user);
}
