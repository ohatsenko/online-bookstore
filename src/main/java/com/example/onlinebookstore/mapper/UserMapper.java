package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.UserRegistrationRequestDto;
import com.example.onlinebookstore.dto.UserRegistrationResponseDto;
import com.example.onlinebookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserRegistrationResponseDto toUserResponse(User user);

    User toModel(UserRegistrationRequestDto userDto);
}
