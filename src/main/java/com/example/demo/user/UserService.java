package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> getUser(){
        return userRepository.findAll();
    }

    public void addUser(AppUser user){
        if (userRepository.findAppUserByEmail(user.getEmail()).isEmpty()) {
            userRepository.save(user);
        }
    }
}
