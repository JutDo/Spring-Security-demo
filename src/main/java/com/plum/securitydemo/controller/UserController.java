package com.plum.securitydemo.controller;

import com.plum.securitydemo.entity.User;
import com.plum.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @GetMapping("/list")
    public List<User> getUserList(){
        return userService.list();
    }
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addOneUser(user);
    }


}
