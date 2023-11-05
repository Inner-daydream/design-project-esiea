package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Program;

import java.util.Optional;

public interface ProgramRepository {
    Optional<Program> findById(String id);
    void save(Program program);
}
