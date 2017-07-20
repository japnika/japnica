package com.example.server.dto;

import com.example.server.domain.Student;

/**
 * Created by japnica on 6/16/2017.
 */
public class StudentDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String gender;
    private String email;
    private String phone;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstName, String middleName, String lastName, int age, String gender, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public StudentDTO(Student student){
        this(student.getId(), student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getAge(), student.getGender(), student.getEmail(), student.getPhone());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
