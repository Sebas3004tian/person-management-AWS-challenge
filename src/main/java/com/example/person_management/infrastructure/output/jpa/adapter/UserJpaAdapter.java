package com.example.person_management.infrastructure.output.jpa.adapter;

import com.example.person_management.domain.model.User;
import com.example.person_management.domain.spi.IUserPersistencePort;
import com.example.person_management.infrastructure.output.jpa.entity.UserEntity;
import com.example.person_management.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.example.person_management.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;

    private final IUserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findOneById(Long id){
        return userRepository.findById(id)
                .map(userEntityMapper::toUser);
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUser(userEntity);
    }
}
