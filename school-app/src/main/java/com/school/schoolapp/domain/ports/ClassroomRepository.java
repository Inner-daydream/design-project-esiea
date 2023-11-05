package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Classroom;

import java.util.Optional;

public interface ClassroomRepository {

    Optional<Classroom> findById(String id);

    void save(Classroom classroom);
    void update(Classroom classroom);
}
