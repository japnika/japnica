package com.example.server.repository;

import com.example.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by japnica on 7/21/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByActivationKey(String key);
}
