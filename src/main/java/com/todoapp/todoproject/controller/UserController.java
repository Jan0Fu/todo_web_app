package com.todoapp.todoproject.controller;

import org.springframework.web.bind.annotation.*;
import com.todoapp.todoproject.model.User;
import com.todoapp.todoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private User getCurrentUser(@RequestBody User user) {
        System.out.println("GET User by username and password *****");
        return userService.getUser(user);
    }

    @GetMapping("/login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
        System.out.println("GET User by username and password *****");
        return userService.getUserByUsername(username, password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user) {
        boolean user_exits = userService.findUserByUsername(user.getUsername());
        if(user_exits) {
            System.out.println("CANT CREATE USER!");
            return false;
        }
        userService.saveUser(user);
        return true;
    }

}
