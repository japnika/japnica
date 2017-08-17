package com.example.server.repository;

import com.example.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by japnica on 8/14/2017.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
