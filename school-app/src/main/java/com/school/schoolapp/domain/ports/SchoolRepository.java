package com.school.schoolapp.domain.ports;
import com.school.schoolapp.domain.implementations.School;
import java.util.Optional;
import java.util.List;

public interface SchoolRepository {
    Optional<School> findById(String id);
    void save(School school);
    void update(School school);
    Optional<List<School>> findAll();
}
