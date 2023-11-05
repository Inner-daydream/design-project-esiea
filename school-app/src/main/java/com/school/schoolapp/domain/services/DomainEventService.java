package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.ports.EventRepository;

import java.util.UUID;

public class DomainEventService implements EventService{
    private final EventRepository eventRepository;

    public DomainEventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    @Override
    public UUID createEvent(IEvent event) {
        eventRepository.save(event);
        return event.getId();
    }

    @Override
    public IEvent getEvent(String id) {
        return eventRepository.findById(id);
    }
}
