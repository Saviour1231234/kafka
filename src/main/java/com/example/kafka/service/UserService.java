package com.example.kafka.service;

import com.example.kafka.entity.User;
import com.example.kafka.exception.NotFoundException;
import com.example.kafka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final KafkaTemplate<String, User> kafkaTemplate;
    private final UserRepository userRepository;

    public void produce(User user) {
        log.info("Producing message " + user);
        kafkaTemplate.send("messages", user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId.toString())
                .orElseThrow(() -> new NotFoundException("Not found user with user id: " + userId));
    }

}
