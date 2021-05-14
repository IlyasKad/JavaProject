package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.User;
import com.travelset.laba3.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        if(!userRepository.existsById(id)) {
            throw new NoSuchEntityElementException(User.class,id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        if(!userRepository.existsById(user.getId())) {
            throw new NoSuchEntityElementException(User.class, user.getId());
        }
        return userRepository.save(user);
    }
}
