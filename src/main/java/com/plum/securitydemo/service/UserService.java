package com.plum.securitydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.plum.securitydemo.entity.User;

public interface UserService extends IService<User> {
    void addOneUser(User user);
}
