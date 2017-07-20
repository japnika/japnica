package com.example.server.repository;

import com.example.server.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by japnica on 6/16/2017.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findOneById(Long id);
}
