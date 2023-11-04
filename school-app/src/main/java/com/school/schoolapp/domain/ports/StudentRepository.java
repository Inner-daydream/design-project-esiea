package com.school.schoolapp.domain.ports;
import com.school.schoolapp.domain.implementations.Student;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Long id);
    void save(Student student);
}