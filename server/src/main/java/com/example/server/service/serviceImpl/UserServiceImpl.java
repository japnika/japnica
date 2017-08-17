package com.example.server.service.serviceImpl;

import com.example.server.constants.AuthoritiesConstants;
import com.example.server.domain.Role;
import com.example.server.domain.User;
import com.example.server.dto.UserDTO;
import com.example.server.repository.RoleRepository;
import com.example.server.repository.UserRepository;
import com.example.server.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by japnica on 7/21/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(true);

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(AuthoritiesConstants.USER));

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }
}
