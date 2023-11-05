package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IPerson;

import java.util.UUID;

public interface EventService {
    UUID createEvent(IEvent event);
    IEvent getEvent(String id);

}
