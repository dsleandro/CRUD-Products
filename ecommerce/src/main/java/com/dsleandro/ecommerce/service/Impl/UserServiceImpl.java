package com.dsleandro.ecommerce.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.dsleandro.ecommerce.models.User;
import com.dsleandro.ecommerce.repository.UserRepository;
import com.dsleandro.ecommerce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User getUserByUsername(String username) {
        User user = null;

        try {
            user = userRepository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUser(User entity) {

        User user = null;

        // get user from DB
        try {
            user = userRepository.findByUsername(entity.getUsername());

            if(user != null){
                // Compares user's password with DB password and returns user if it matches
                return passwordEncoder.matches(entity.getPassword(), user.getPassword()) ? user : null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
       
    }

    @Override
    public List<User> getAll() {

        List<User> userList = new ArrayList<>();

        try {
            userList = userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User saveUser(User entity) {

        User user = null;

        // encrypting password
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        try {
            user = userRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User deleteByUserId(String id) {
        User user = null;

        try {
            user = userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
