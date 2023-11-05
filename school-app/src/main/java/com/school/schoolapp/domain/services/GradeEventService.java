package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.GradeEvent;

import java.util.UUID;

public interface GradeEventService {
    UUID createGradeEvent(GradeEvent gradeEvent);
}
