package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.TeacherRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DomainTeacherService implements TeacherService{
    private final TeacherRepository teacherRepository;

    public DomainTeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @Override
    public UUID createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return teacher.getId();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.update(teacher);
    }
    @Override
    public Teacher getTeacher(String id) {
        return teacherRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().get();
    }
}
