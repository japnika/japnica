package com.example.server.service.serviceImpl;

import com.example.server.domain.User;
import com.example.server.dto.UserDTO;
import com.example.server.repository.UserRepository;
import com.example.server.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by japnica on 7/21/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);

        return user;
    }
}
