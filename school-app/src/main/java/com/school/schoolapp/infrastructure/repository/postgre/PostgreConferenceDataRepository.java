package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.infrastructure.entities.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PostgreConferenceDataRepository extends JpaRepository<ConferenceEntity, String> {
    // @Override
    // @Query("SELECT c FROM ConferenceEntity c")
    // List<ConferenceEntity> findAll();
}
