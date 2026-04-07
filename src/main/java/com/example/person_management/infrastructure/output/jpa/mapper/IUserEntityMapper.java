package com.example.person_management.infrastructure.output.jpa.mapper;

import com.example.person_management.domain.model.User;
import com.example.person_management.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {

    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
}
