package com.school.schoolapp.infrastructure.repository.postgre;
import java.util.Optional;
import java.util.UUID;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.ports.EventRepository;
import com.school.schoolapp.infrastructure.entities.EventEntity;

import org.springframework.beans.factory.annotation.Autowired;
public class PostgreEventRepository implements EventRepository {
    private final PostgreEventDataRepository postgreEventDataRepository;
    @Autowired
    public PostgreEventRepository(PostgreEventDataRepository postgreEventDataRepository) {
        this.postgreEventDataRepository = postgreEventDataRepository;
    }

    @Override
    public void save(IEvent event) {
        EventEntity eventEntity = new EventEntity(event);
        this.postgreEventDataRepository.save(eventEntity);
    }  
}
