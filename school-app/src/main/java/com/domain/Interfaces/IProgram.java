package com.domain.Interfaces;

import com.domain.abstractions.Event;

import java.util.List;

public interface IProgram {
    void addEvent(IEvent event);
    List<Event> getEvents();
    String getProgramName();
    IEvent getEventByName(String eventName);
}
