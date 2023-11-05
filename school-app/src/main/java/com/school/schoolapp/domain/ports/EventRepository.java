package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.Interfaces.IEvent;

public interface EventRepository {
    public void save(IEvent event);

    // public IEvent findById(String id);
}
