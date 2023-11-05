package com.school.schoolapp.infrastructure.repository.postgre.program;

import com.school.schoolapp.domain.implementations.Program;
import com.school.schoolapp.domain.ports.ProgramRepository;
import com.school.schoolapp.infrastructure.entities.ProgramEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostgreProgramRepository implements ProgramRepository {
    private final PostgreProgramDataRepository postgreProgramDataRepository;
    @Autowired
    public PostgreProgramRepository(PostgreProgramDataRepository postgreProgramDataRepository) {
        this.postgreProgramDataRepository = postgreProgramDataRepository;
    }

    @Override
    public Optional<Program> findById(String id) {
        Optional<ProgramEntity> programEntity = this.postgreProgramDataRepository.findById(id);
        if (programEntity.isPresent()) {
            Program program = new Program(
                    programEntity.get().getName()
            );
            return Optional.of(program);
        }
        return Optional.empty();
    }

    @Override
    public void save(Program program) {
        ProgramEntity programEntity = new ProgramEntity(program);
        this.postgreProgramDataRepository.save(programEntity);
    }
}
