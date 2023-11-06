package com.school.schoolapp.infrastructure.repository.postgre.classroom;

import com.school.schoolapp.infrastructure.entities.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreClassroomDataRepository extends JpaRepository<ClassroomEntity, String> {
}
