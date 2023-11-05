package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.GradeEvent;
import com.school.schoolapp.domain.ports.GradeEventRepository;

import java.util.UUID;

public class DomainGradeEventService implements GradeEventService{
    private final GradeEventRepository gradeEventRepository;

    public DomainGradeEventService(GradeEventRepository gradeEventRepository) {
        this.gradeEventRepository = gradeEventRepository;
    }

    @Override
    public UUID createGradeEvent(GradeEvent gradeEvent) {
        gradeEventRepository.save(gradeEvent);
        return gradeEvent.getId();
    }
}
