package com.school.schoolapp.infrastructure.repository.postgre.program;

import com.school.schoolapp.infrastructure.entities.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreProgramDataRepository extends JpaRepository<ProgramEntity, String> {
}
