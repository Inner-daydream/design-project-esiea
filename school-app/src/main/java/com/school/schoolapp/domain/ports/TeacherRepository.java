package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Teacher;

import java.util.Optional;

public interface TeacherRepository {
    Optional<Teacher> findById(String id);

    void save(Teacher teacher);
}