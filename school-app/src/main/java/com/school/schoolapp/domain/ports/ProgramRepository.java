package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramRepository {
    Optional<Program> findById(String id);
    Optional<List<Program>> findAll();
    void save(Program program);
    void update(Program program);
}
