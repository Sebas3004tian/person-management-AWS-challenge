package com.example.person_management.infrastructure.configuration;

import com.example.person_management.domain.api.IUserServicePort;
import com.example.person_management.domain.spi.IUserPersistencePort;
import com.example.person_management.domain.usecase.UserUseCase;
import com.example.person_management.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.example.person_management.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.example.person_management.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository,userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(
                userPersistencePort()

        );
    }

}
