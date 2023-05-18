package com.springdev.lab3mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Student {

    @Id
    private UUID id;
    private String name;
    private int age;
}
