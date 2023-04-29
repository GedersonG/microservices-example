package com.example.usermicroservice.mapper;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);
}
