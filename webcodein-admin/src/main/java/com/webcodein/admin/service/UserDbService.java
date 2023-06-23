package com.webcodein.admin.service;


import ch.qos.logback.core.testUtil.RandomUtil;
import com.webcodein.admin.data.entity.User;
import com.webcodein.admin.data.mapper.UserMapper;
import com.webcodein.admin.dto.UserDto;
import com.webcodein.admin.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        userDto.setUuid(UUID.randomUUID().toString());
        userMapper.updateGivenEntityDataByDto(user, userDto);
        User resultedUser = this.userRepository.save(user);
        UserDto resultedUserDto = new UserDto();
        userMapper.updateGivenDtoByEntityData(resultedUser, resultedUserDto);
        return resultedUserDto;
    }

    public UserDto update(UserDto userDto) {
        User currentUser;
        UserDto resultedUserDto;
        System.out.println("userDto.getUuid() = " + userDto.getUuid());
        currentUser = this.userRepository.findByUuid(userDto.getUuid());
        userMapper.updateGivenEntityDataByDto(currentUser, userDto);
        User resultedUser = this.userRepository.save(currentUser);
        resultedUserDto = new UserDto();
        userMapper.updateGivenDtoByEntityData(resultedUser, resultedUserDto);
        return resultedUserDto;
    }

    public void delete(UserDto userDto) {
        User currentUser;
        currentUser = this.userRepository.findByUuid(userDto.getUuid());
        this.userRepository.delete(currentUser);
    }
}  