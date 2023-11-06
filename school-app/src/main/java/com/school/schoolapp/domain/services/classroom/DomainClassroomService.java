package com.school.schoolapp.domain.services.classroom;

import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.ports.ClassroomRepository;
import com.school.schoolapp.domain.services.classroom.ClassroomService;

import java.util.UUID;
import java.util.List;

public class DomainClassroomService implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    public DomainClassroomService(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public UUID createClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
        return classroom.getId();
    }

    @Override
    public Classroom getClassroom(String id) {
        return classroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Classroom not found"));
    }

    @Override
    public void updateClassroom(Classroom classroom) {
        classroomRepository.update(classroom);
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll().get();
    }
    
}
