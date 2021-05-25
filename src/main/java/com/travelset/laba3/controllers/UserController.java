package com.travelset.laba3.controllers;

import com.travelset.laba3.model.entity.User;
import com.travelset.laba3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Collection<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<User>  updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }


}
