package com.travelset.laba3.controllers;

import com.travelset.laba3.model.entity.User;
import com.travelset.laba3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    public User saveUser(User user){
        return userService.saveUser(user);
    }
    public void deleteUser(int id){
        userService.deleteUser(id);
    }
    public User updateUser(User user){
        return userService.updateUser(user);
    }
}
