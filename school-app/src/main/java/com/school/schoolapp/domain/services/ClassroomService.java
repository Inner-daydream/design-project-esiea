package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Classroom;
import java.util.UUID;
import java.util.List;

public interface ClassroomService {
    UUID createClassroom(Classroom classroom);
    Classroom getClassroom(String id);
    void updateClassroom(Classroom classroom);
    List<Classroom> getAllClassrooms();
}
