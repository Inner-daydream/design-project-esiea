package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.TeacherRepository;

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
}
