package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreEventDataRepository extends JpaRepository<EventEntity, String> {
    
}
