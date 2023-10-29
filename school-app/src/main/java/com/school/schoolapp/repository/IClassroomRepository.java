package com.school.schoolapp.repository;

import com.school.schoolapp.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
    @Query("SELECT c FROM Classroom c WHERE c.name = ?1")
    public Classroom findByName(String name);
}
