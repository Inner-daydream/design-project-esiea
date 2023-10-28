package com.school.schoolapp.repository;

import com.school.schoolapp.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchoolRepository extends JpaRepository<School, Long> {
}
