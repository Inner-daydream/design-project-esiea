package com.domain.Interfaces;

import java.util.List;

public interface IProgram {
    String getID();

    void setID(String id);
    void addEvent(IEvent event);
    List<IEvent> getEvents();
    String getProgramName();
    IEvent getEventByName(String eventName);
}
