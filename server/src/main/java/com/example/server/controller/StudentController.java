package com.example.server.controller;

import com.example.server.domain.Student;
import com.example.server.dto.StudentDTO;
import com.example.server.service.serviceInterface.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by japnica on 6/16/2017.
 */
@Controller
@RequestMapping("/api/student")
public class StudentController {

    private final Logger log = LoggerFactory.getLogger(StudentController.class.getName());

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody StudentDTO studentDTO){
        Student student = studentService.saveStudent(studentDTO);

        log.debug("Successfully inserted.");
        System.out.println("success");
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity<Object>(students, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO){
        studentService.updateStudent(studentDTO);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
