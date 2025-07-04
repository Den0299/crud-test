package com.example.crud_test.controller;

import com.example.crud_test.entity.Student;
import com.example.crud_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student newStudent = studentService.createStudent(student);

        return ResponseEntity.ok().body(newStudent);
    }

    @GetMapping("/select-all-students")
    public ResponseEntity<List<Student>> selectAllStudents() {

        List<Student> students = studentService.selectAllStudents();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Student>> selectAllStudents(@PathVariable Long id) {

        Optional<Student> student = studentService.findById(id);

        if (student.isPresent()) {
            return ResponseEntity.ok().body(student);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<Optional<Student>> deleteStudent(@RequestBody Student student) {

        Optional<Student> optionalStudent = studentService.deleteStudent(student);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(optionalStudent);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<Optional<Student>> updateStudent(@PathVariable Long id,
                                                     @RequestBody Student studentDetails) {

        Optional<Student> optionalStudent = studentService.updateStudent(id, studentDetails);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalStudent);
    }
}
