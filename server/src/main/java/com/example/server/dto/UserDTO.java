package com.example.server.dto;

import com.example.server.domain.Role;
import com.example.server.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by japnica on 7/21/2017.
 */
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private boolean enabled;
    private Set<String> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String password, boolean enabled, Set<String> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public UserDTO(User user) {
        this(user.getId(), user.getUserName(), user.getPassword(),
                user.getEnabled(), user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
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

    public boolean isEnabled() {
        return enabled;
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
