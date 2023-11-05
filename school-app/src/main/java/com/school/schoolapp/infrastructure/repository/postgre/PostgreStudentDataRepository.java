package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.infrastructure.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreStudentDataRepository extends JpaRepository<StudentEntity, String> {
}
