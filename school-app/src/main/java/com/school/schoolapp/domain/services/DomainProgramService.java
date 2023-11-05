package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Program;
import com.school.schoolapp.domain.ports.ProgramRepository;

import java.util.UUID;

public class DomainProgramService implements ProgramService {
    private final ProgramRepository programRepository;

    public DomainProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public UUID createProgram(Program program) {
        programRepository.save(program);
        return program.getId();
    }
}
