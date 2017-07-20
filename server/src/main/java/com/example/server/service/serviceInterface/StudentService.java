package com.example.server.service.serviceInterface;

import com.example.server.domain.Student;
import com.example.server.dto.StudentDTO;
import com.example.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 6/16/2017.
 */
public interface StudentService {
   public Student saveStudent(StudentDTO studentDTO);

    List<Student> getAllStudent();

    void updateStudent(StudentDTO studentDTO);

    Optional<Student> getStudentById(Long id);

    void deleteStudentById(Long id);
}
