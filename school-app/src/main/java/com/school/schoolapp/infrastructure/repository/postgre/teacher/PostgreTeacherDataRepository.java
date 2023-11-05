package com.school.schoolapp.infrastructure.repository.postgre.teacher;

import com.school.schoolapp.infrastructure.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreTeacherDataRepository extends JpaRepository<TeacherEntity, String> {
}
