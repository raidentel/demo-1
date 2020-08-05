package com.example.demo.service.user.impl;

import com.example.demo.model.user.UserDetail;
import com.example.demo.model.user.Users;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userService.getByUsername(userName);
        if (user != null) {
            return UserDetail.builder().user(user).build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }


}
