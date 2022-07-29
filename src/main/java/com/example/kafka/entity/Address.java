package com.example.kafka.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "Address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Address {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    String id;

    String street;

    public Address() {
        this.id = new ObjectId().toString();
    }
}
