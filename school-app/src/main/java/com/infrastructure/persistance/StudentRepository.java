package com.infrastructure.persistance;

import com.domain.implementations.School;
import com.domain.implementations.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
}
