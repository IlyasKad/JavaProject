package com.travelset.laba3.services;

import com.travelset.laba3.model.entity.User;
import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(int id);
    User updateUser(User user);
}
