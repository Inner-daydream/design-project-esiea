package com.school.schoolapp.infrastructure.repository.postgre.student;

import com.school.schoolapp.infrastructure.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreStudentDataRepository extends JpaRepository<StudentEntity, String> {
}
