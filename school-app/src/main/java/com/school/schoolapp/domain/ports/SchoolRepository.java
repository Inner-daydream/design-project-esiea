package com.school.schoolapp.domain.ports;
import com.school.schoolapp.domain.implementations.School;
import java.util.Optional;
public interface SchoolRepository {
    Optional<School> findById(String id);
    void save(School school);
}
