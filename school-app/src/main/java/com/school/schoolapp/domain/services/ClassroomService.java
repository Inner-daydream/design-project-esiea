package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Classroom;

import java.util.UUID;

public interface ClassroomService {
    UUID createClassroom(Classroom classroom);
}
