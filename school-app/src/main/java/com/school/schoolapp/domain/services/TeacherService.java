package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Teacher;

import java.util.UUID;

public interface TeacherService {
    UUID createTeacher(Teacher teacher);

    Teacher getTeacher(String id);
}
