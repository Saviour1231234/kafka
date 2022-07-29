package com.example.kafka.controller;

import com.example.kafka.entity.User;
import com.example.kafka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/send")
    public User generate(@RequestBody User user) {
        userService.produce(user);
        return user;
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get/{userId}")
    public User getUsers(@PathVariable("userId") ObjectId userId) {
        return userService.getUserById(userId);
    }
}
