package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.Interfaces.IEvent;
import java.util.UUID;

public interface EventService {
    UUID createEvent(IEvent event);
}
