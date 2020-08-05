package com.example.demo.service.user.impl;

import com.example.demo.dao.user.UserDao;
import com.example.demo.dto.user.UserDto;
import com.example.demo.mapper.IUserMapper;
import com.example.demo.model.user.Users;
import com.example.demo.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;
    private IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public UserDto create(UserDto userDto) {
        return userMapper.mapUsertoDTO(userDao.save(userMapper.mapDTOtoUser(userDto)));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public UserDto getById(Long id) {
        return userMapper.mapUsertoDTO(userDao.getOne(id));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Users getByUsername(String username) {
        final Optional<Users> user = userDao.getByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public UserDto getUserDtoByUsername(String username) {
        final Optional<Users> user = userDao.getByUsername(username);
        if (user.isPresent()) {
            return userMapper.mapUsertoDTO(user.get());
        } else {
            return null;
        }
    }
}
