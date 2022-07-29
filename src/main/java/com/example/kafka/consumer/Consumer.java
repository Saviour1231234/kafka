package com.example.kafka.consumer;

import com.example.kafka.entity.User;
import com.example.kafka.repository.AddressRepository;
import com.example.kafka.repository.MobileRepository;
import com.example.kafka.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final MobileRepository mobileRepository;

    @KafkaListener(topics = "messages", groupId = "group")
    public void consume(User user){
        log.info("consuming message" + user);
        userRepository.save(user);
        addressRepository.saveAll(user.getAddress());
        mobileRepository.saveAll(user.getAddress().stream().findAny().get().getMobile());
    }
}
