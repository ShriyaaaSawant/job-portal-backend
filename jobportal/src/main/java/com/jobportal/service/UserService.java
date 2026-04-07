package com.jobportal.service;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //save user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //Get all user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;

        } else {
            return null;
        }
    }

}
