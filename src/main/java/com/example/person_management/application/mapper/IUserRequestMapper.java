package com.example.person_management.application.mapper;

import com.example.person_management.application.dto.request.CreateUserRequestDto;
import com.example.person_management.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    User toUser(CreateUserRequestDto createUserRequestDto);
}
