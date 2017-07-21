package com.example.server.dto;

import com.example.server.domain.User;

/**
 * Created by japnica on 7/21/2017.
 */
public class UserDTO {
    private Long id;
    private String userName;
    private String password;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserDTO(User user){
        this(user.getId(), user.getUserName(), user.getPassword());
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
