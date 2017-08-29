package com.example.server.service.serviceInterface;

import com.example.server.domain.User;
import com.example.server.dto.UserDTO;

/**
 * Created by japnica on 7/21/2017.
 */
public interface UserService {

    User saveUser(UserDTO userDTO);

    void activateUser(String key);
}
