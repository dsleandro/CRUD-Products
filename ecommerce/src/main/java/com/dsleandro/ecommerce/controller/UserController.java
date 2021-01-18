package com.dsleandro.ecommerce.controller;

import com.dsleandro.ecommerce.models.User;
import com.dsleandro.ecommerce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> signup(@RequestBody User newUser) {
       
        User user = userService.saveUser(newUser);

        return ResponseEntity.ok(user);
    }

}
