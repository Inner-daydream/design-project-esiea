package com.school.schoolapp.infrastructure.repository.postgre.GradeEvent;

import com.school.schoolapp.infrastructure.entities.GradeEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreGradeEventDataRepository extends JpaRepository<GradeEventEntity, String> {
}
