package com.example.demo.mapper;


import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper( IUserMapper.class );

    /**
     * Map User dto to User entity.
     *
     * @param userDto
     * @return User
     */
    Users mapDTOtoUser(UserDto userDto);

    /**
     * Map User dto to User entity.
     *
     * @param user
     * @return UserDto
     */
    UserDto mapUsertoDTO(Users user);
}
