package com.school.schoolapp.infrastructure.repository.postgre.course;

import com.school.schoolapp.infrastructure.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreCourseDataRepository extends JpaRepository<CourseEntity, String> {
}
