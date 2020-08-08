package com.example.demo.mapper;


import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper( IUserMapper.class );

    Users mapDTOtoUser(UserDto userDto);
    UserDto mapUsertoDTO(Users user);
}
