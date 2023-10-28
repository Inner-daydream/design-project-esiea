package com.domain.Interfaces;

import java.util.List;

public interface IProgram {
    void addEvent(IEvent event);
    List<IEvent> getEvents();
    String getProgramName();
    IEvent getEventByName(String eventName);
}
