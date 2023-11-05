package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Classroom;

import java.util.Optional;
import java.util.List;
public interface ClassroomRepository {

    Optional<Classroom> findById(String id);
    Optional<List<Classroom>> findAll();
    void save(Classroom classroom);
    void update(Classroom classroom);
}
