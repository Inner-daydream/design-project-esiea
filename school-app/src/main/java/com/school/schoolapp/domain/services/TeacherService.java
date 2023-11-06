package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Teacher;

import java.util.UUID;
import java.util.List;

public interface TeacherService {
    UUID createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    Teacher getTeacher(String id);
    List<Teacher> getAllTeachers();
}
