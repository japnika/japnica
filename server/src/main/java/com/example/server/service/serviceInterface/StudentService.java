package com.example.server.service.serviceInterface;

import com.example.server.domain.Student;
import com.example.server.dto.StudentDTO;
import com.example.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by japnica on 6/16/2017.
 */
public interface StudentService {
   public Student saveStudent(StudentDTO studentDTO);
}
