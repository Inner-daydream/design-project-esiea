package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.Interfaces.IProgram;

import java.util.ArrayList;
import java.util.List;

public class Program implements IProgram {
    private String name;
    private List<IEvent> events;

    public Program(String name) {
        this.name = name;
        this.events = new ArrayList<>();
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
