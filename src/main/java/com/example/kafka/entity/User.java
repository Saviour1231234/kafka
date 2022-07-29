package com.example.kafka.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Document(collection = "Users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class User {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    String id;

    String name;

    String surname;

    Integer age;

    @DBRef(lazy = true)
    List<Address> address;

    public User() {
        this.id = new ObjectId().toString();
    }
}
