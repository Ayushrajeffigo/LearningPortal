package com.effigo.learningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.effigo.learningPortal.dto.RegisterUserDto;
import com.effigo.learningPortal.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	User registerUserDtoToUser(RegisterUserDto registerUserDto);

	RegisterUserDto userToRegisterUserDto(User user);
}
