package com.school.schoolapp.repository;

import com.school.schoolapp.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
}
