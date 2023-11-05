package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.infrastructure.entities.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreClassroomDataRepository extends JpaRepository<ClassroomEntity, String> {
}
