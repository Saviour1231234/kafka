package com.example.kafka.controller;

import com.example.kafka.entity.User;
import com.example.kafka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/send")
    public User generate(@RequestBody User user){
        userService.produce(user);
        return user;
    }
}
