package com.example.kafka.service;

import com.example.kafka.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final KafkaTemplate<String, User> kafkaTemplate;
    public void produce(User user) {
        log.info("Producing message " + user);
        kafkaTemplate.send("messages", user);
    }
}
