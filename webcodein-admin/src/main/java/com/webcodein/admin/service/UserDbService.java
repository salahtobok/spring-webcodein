package com.webcodein.admin.service;


import com.webcodein.admin.data.entity.User;
import com.webcodein.admin.data.mapper.UserMapper;
import com.webcodein.admin.dto.UserDto;
import com.webcodein.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDbService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserDbService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Iterable<User> getUserList() {
        Iterable<User> userIterable = this.userRepository.findAll();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);
        return userIterable;
    }

    public UserDto create(UserDto userDto) {
        User user = new User();
        userMapper.updateGivenEntityDataByDto(user, userDto);
        User resultedUser = this.userRepository.save(user);
        UserDto resultedUserDto = new UserDto();
        userMapper.updateGivenDtoByEntityData(resultedUser,resultedUserDto);
        return resultedUserDto;
    }
}  