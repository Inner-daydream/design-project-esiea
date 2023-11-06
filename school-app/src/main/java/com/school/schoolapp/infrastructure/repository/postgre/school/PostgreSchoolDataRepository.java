package com.school.schoolapp.infrastructure.repository.postgre.school;
import com.school.schoolapp.infrastructure.entities.SchoolEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PostgreSchoolDataRepository extends JpaRepository<SchoolEntity, String> {
    // @Query("SELECT s FROM school s WHERE s.id = ?1")
    // public Optional<SchoolEntity> findById(String id);
    
}
