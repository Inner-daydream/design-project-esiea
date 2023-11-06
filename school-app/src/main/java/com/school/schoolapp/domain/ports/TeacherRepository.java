package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Teacher;

import java.util.Optional;

import java.util.List;

public interface TeacherRepository {
    Optional<Teacher> findById(String id);
    Optional<List<Teacher>> findAll();
    void update(Teacher teacher);
    void save(Teacher teacher);
}
