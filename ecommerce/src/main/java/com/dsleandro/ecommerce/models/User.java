package com.dsleandro.ecommerce.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 434732343404132333L;

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private String username;

    private String password;
}
