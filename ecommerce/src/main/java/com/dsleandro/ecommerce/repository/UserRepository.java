package com.dsleandro.ecommerce.repository;

import java.io.Serializable;

import com.dsleandro.ecommerce.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, Serializable> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User deleteById(String id);
}
