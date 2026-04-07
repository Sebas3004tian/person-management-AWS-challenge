package com.example.person_management.domain.usecase;

import com.example.person_management.domain.api.IUserServicePort;
import com.example.person_management.domain.model.User;
import com.example.person_management.domain.spi.IUserPersistencePort;
import com.example.person_management.infrastructure.exception.UserNotFoundException;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User getUserById(Long id){
        return userPersistencePort.findOneById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(id)
                );
    }

    @Override
    public User createUser(User user){
        return userPersistencePort.createUser(user);
    }

}
