package com.example.server.controller;

import com.example.server.domain.Student;
import com.example.server.dto.StudentDTO;
import com.example.server.exception.StudentException;
import com.example.server.service.serviceInterface.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by japnica on 6/16/2017.
 */
@Controller
@RequestMapping("/api")
public class StudentController {

    private final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/student")
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody StudentDTO studentDTO){
        try {
            Student student = studentService.saveStudent(studentDTO);

            log.debug("Successfully inserted.");
            return new ResponseEntity<Student>(student, HttpStatus.CREATED);
        }catch (Exception e){
            throw new StudentException("Student information Error");
        }
    }
}
