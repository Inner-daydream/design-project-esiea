package com.school.schoolapp.infrastructure.repository.postgre.teacher;

import com.school.schoolapp.infrastructure.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreTeacherDataRepository extends JpaRepository<TeacherEntity, String> {
}
