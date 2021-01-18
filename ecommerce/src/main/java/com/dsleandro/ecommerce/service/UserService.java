package com.dsleandro.ecommerce.service;

import java.util.List;

import com.dsleandro.ecommerce.models.User;

public interface UserService {

    User getUserByUsername(String username);

    User getUser(User user);

    List<User> getAll();

    User saveUser(User entity);

    User deleteByUserId(String id);


}