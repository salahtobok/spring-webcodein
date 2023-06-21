package com.webcodein.admin.service;


import com.webcodein.admin.entity.User;
import com.webcodein.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDbService {

    private final UserRepository userRepository;


    @Autowired
    public UserDbService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUserList(){
        Iterable<User> userIterable = this.userRepository.findAll();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);
        return userIterable;
    }
}  