package com.school.schoolapp.controller;

import com.school.schoolapp.entity.Student;
import com.school.schoolapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path="api/v1/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
