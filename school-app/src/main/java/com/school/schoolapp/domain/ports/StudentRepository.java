package com.school.schoolapp.domain.ports;
import com.school.schoolapp.domain.implementations.Student;
import java.util.Optional;
import java.util.List;
public interface StudentRepository {
    Optional<Student> findById(String id);
    Optional<List<Student>> findAllById(List<String> ids);
    Optional<List<Student>> findAll();
    void save(Student student);
    void update(Student student);
}