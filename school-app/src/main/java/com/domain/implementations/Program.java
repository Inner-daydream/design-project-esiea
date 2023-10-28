package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.Interfaces.IProgram;

import java.util.ArrayList;
import java.util.List;

public class Program implements IProgram {
    private String id;
    private String name;
    private List<IEvent> events;

    public Program(String id, String name) {
        this.id = id;
        this.name = name;
        this.events = new ArrayList<>();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    public void addEvent(IEvent event) {
        events.add(event);
    }

    public List<IEvent> getEvents() {
        return events;
    }

    public String getProgramName() {
        return name;
    }

    @Override
    public IEvent getEventByName(String eventName) {
        return this.events.stream().filter(event -> event.getEventName().equals(eventName)).findFirst().orElseThrow();
    }
}
