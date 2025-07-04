package com.example.crud_test.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Service
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;
    private String surname;
    private boolean isWorking;

    public Student() {
    }

    public Student(String name, String surname, boolean isWorking) {
        this.name = name;
        this.surname = surname;
        this.isWorking = isWorking;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
