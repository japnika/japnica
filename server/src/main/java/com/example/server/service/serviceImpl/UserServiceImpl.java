package com.example.server.service.serviceImpl;

import com.example.server.config.MailService;
import com.example.server.constants.AuthoritiesConstants;
import com.example.server.domain.Role;
import com.example.server.domain.User;
import com.example.server.dto.UserDTO;
import com.example.server.exception.UserNotFoundException;
import com.example.server.repository.RoleRepository;
import com.example.server.repository.UserRepository;
import com.example.server.service.serviceInterface.UserService;
import org.apache.commons.lang3.RandomStringUtils;
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

    @Autowired
    MailService mailService;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setActivationKey(RandomStringUtils.randomAlphanumeric(20));

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(AuthoritiesConstants.USER));

        user.setRoles(roles);
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
        String msg = "Thanks <b>"+user.getUserName()+"</b>, for registering.<br/>" +
                " Please click on the link below for activating your account:<br/> <br/>" +
                "<a href='http://localhost:4200/activation?key="+user.getActivationKey()+"'>Click here</a>";
        mailService.sendMail(msg, user.getEmail(), "Account Activation");

        return user;
    }

    @Override
    public User activateUser(String key) {
        User user = userRepository.findByActivationKey(key);
        if(user == null){
            throw new UserNotFoundException("User not found with activation key :" +key);
        }
        user.setEnabled(true);
//        user.setActivationKey(null);
        userRepository.save(user);
        return user;
    }
}
