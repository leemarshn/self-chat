package com.lenhac.talk.service;


import com.lenhac.talk.model.User;
import com.lenhac.talk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        return userRepository.save(user);
    }
}
