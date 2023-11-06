package com.school.schoolapp.domain.services.program;

import com.school.schoolapp.domain.implementations.Program;
import com.school.schoolapp.domain.ports.ProgramRepository;

import java.util.List;
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

    @Override
    public void updateProgram(Program program) {
        programRepository.update(program);
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll().get();
    }
}
