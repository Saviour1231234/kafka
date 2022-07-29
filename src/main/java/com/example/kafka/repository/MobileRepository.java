package com.example.kafka.repository;

import com.example.kafka.entity.Mobile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MobileRepository extends MongoRepository<Mobile,String> {
}
