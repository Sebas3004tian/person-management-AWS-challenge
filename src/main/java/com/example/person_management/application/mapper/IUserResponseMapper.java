package com.example.person_management.application.mapper;

import com.example.person_management.application.dto.response.UserResponseDto;
import com.example.person_management.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    @Mapping(source = "id", target = "userId")
    UserResponseDto toResponse(User user);

}
