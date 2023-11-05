package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Student;

import java.util.UUID;
import java.util.List;
public interface StudentService {
    UUID createStudent(Student student);
    List<Student> getStudents(List<String> ids);
}
