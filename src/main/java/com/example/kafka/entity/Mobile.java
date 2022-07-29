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

@Document(collection = "Mobile")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Mobile {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    String id;

    String mobileNumber;
    String mobileNumber2;

    public Mobile() {
        this.id = new ObjectId().toString();
    }
}
