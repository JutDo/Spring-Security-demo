package com.plum.securitydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plum.securitydemo.config.DBUserDetailsManager;
import com.plum.securitydemo.entity.User;
import com.plum.securitydemo.mapper.UserMapper;
import com.plum.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DBUserDetailsManager dbUserDetailsManager;
    @Override
    public void addOneUser(User user) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User.
                withDefaultPasswordEncoder().
                username(user.getUsername()).
                password(user.getPassword()).
                build();
        dbUserDetailsManager.createUser(userDetails);
    }
}
