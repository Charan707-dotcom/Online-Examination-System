package com.onlineexam.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.model.Student;
import com.onlineexam.repository.StudentRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final StudentRepository studentRepository;

    public LoginController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public String login(@RequestBody Student student) {

        return studentRepository.findByUsername(student.getUsername())
                .filter(existingStudent ->
                        existingStudent.getPassword().equals(student.getPassword()))
                .map(existingStudent -> "Login successful! Welcome to Online Examination")
                .orElse("Invalid username or password");
    }
}