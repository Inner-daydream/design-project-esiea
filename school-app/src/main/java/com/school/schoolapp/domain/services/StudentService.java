package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Student;

import java.util.UUID;

public interface StudentService {
    UUID createStudent(Student student);
}
