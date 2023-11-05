package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.ports.StudentRepository;

import java.util.UUID;

public class DomainStudentService implements StudentService{
    private final StudentRepository studentRepository;

    public DomainStudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public UUID createStudent(Student student) {
        studentRepository.save(student);
        return student.getId();
    }
}
