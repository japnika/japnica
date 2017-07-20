package com.example.server.service.serviceImpl;

import com.example.server.domain.Student;
import com.example.server.dto.StudentDTO;
import com.example.server.repository.StudentRepository;
import com.example.server.service.serviceInterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 6/16/2017.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setGender(studentDTO.getGender());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());

        studentRepository.save(student);

        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        studentRepository.findOneById(studentDTO.getId())
                .ifPresent(student -> {
                    student.setFirstName(studentDTO.getFirstName());
                    student.setMiddleName(studentDTO.getMiddleName());
                    student.setLastName(studentDTO.getLastName());
                    student.setAge(studentDTO.getAge());
                    student.setGender(studentDTO.getGender());
                    student.setEmail(studentDTO.getEmail());
                    student.setPhone(studentDTO.getPhone());
                    studentRepository.save(student);
                });
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findOneById(id);
        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.findOneById(id).ifPresent(student -> {
            studentRepository.delete(student);
        });
    }
}
