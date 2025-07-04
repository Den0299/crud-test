package com.example.crud_test.service;

import com.example.crud_test.entity.Student;
import com.example.crud_test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> deleteStudent(Student student) {
        studentRepository.delete(student);
        return Optional.of(student);
    }

    public Optional<Student> updateStudent(Long id, Student studentDetails) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setWorking(studentDetails.isWorking());

            Student student = studentRepository.save(optionalStudent.get());
            return Optional.of(student);
        }

        return Optional.empty();
    }

}
