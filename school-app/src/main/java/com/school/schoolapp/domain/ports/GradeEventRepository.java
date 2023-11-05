package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.GradeEvent;

import java.util.Optional;

public interface GradeEventRepository {
    Optional<GradeEvent> findById(String id);
    void save(GradeEvent school);
}
