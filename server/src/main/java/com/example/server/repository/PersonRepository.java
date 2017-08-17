package com.example.server.repository;

import com.example.server.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by japnica on 8/2/2017.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
