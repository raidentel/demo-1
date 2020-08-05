package com.example.demo.service.user;

import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.Users;

public interface IUserService {

    UserDto create(UserDto userDto);

    UserDto getById(Long id);

    Users getByUsername(String username);

    UserDto getUserDtoByUsername(String username);
}
