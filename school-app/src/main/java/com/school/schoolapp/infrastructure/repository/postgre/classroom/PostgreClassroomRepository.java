package com.school.schoolapp.infrastructure.repository.postgre.classroom;

import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.ports.ClassroomRepository;
import com.school.schoolapp.infrastructure.entities.ClassroomEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Component
public class PostgreClassroomRepository implements ClassroomRepository {

    private final PostgreClassroomDataRepository postgreClassroomDataRepository;
    @Autowired
    public PostgreClassroomRepository(PostgreClassroomDataRepository postgreClassroomDataRepository) {
        this.postgreClassroomDataRepository = postgreClassroomDataRepository;
    }

    @Override
    public Optional<Classroom> findById(String id) {
        Optional<ClassroomEntity> classroomEntity = this.postgreClassroomDataRepository.findById(id);
        if (classroomEntity.isPresent()) {
            Classroom classroom = new Classroom(classroomEntity.get().getName(), classroomEntity.get().getBuildingName(), classroomEntity.get().getCapacity(), UUID.fromString(classroomEntity.get().getId()));
            return Optional.of(classroom);
        }
        return Optional.empty();
    }

    @Override
    public void save(Classroom classroom) {
        ClassroomEntity classroomEntity = new ClassroomEntity(classroom);
        this.postgreClassroomDataRepository.save(classroomEntity);
    }

    @Override
    public void update(Classroom classroom) {
        ClassroomEntity classroomEntity = new ClassroomEntity(classroom);
        this.postgreClassroomDataRepository.save(classroomEntity);
    }


    public Optional<List<Classroom>> findAll() {
        List<ClassroomEntity> classroomEntities = this.postgreClassroomDataRepository.findAll();
        if (classroomEntities.size() > 0) {
            List<Classroom> classrooms = classroomEntities.stream().map(classroomEntity ->
                new Classroom(
                    classroomEntity.getName(),
                    classroomEntity.getBuildingName(), 
                    classroomEntity.getCapacity(), 
                    UUID.fromString(classroomEntity.getId())
                )).toList();
            return Optional.of(classrooms);
        }
        return Optional.empty();
    }
}
