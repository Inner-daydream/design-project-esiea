package com.school.schoolapp.infrastructure.repository.postgre.event;

import com.school.schoolapp.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreEventDataRepository extends JpaRepository<EventEntity, String> {
    
}
