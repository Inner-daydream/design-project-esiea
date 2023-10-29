package com.school.schoolapp.repository;

import com.school.schoolapp.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE s.name = ?1")
    public School findByName(String name);
}
