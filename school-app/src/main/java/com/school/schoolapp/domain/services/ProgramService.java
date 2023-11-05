package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Program;

import java.util.UUID;

public interface ProgramService {
    UUID createProgram(Program program);
    void updateProgram(Program program);
}
