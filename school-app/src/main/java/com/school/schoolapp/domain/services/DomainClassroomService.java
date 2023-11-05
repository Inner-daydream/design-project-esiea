package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.ports.ClassroomRepository;

import java.util.UUID;

public class DomainClassroomService implements ClassroomService{
    private final ClassroomRepository classroomRepository;
    public DomainClassroomService(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public UUID createClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
        return classroom.getId();
    }
}
