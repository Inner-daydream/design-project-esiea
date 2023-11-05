package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.ports.StudentRepository;

import java.util.List;
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


    @Override
    public List<Student> getStudents(List<String> ids) {
        return studentRepository.findAllById(ids).get();
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }


}
