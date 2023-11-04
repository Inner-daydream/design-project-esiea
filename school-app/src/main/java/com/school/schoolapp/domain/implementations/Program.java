package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IProgram;
import com.school.schoolapp.domain.abstractions.Event;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Table
@Entity
public class Program implements IProgram {
    private String name;
    @OneToMany
    private List<Event> events;
    @Id
    @SequenceGenerator(
            name = "_sequenceProgram",
            sequenceName = "_sequenceProgram",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "_sequenceProgram"
    )
    private Long id;

    public Program(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }

    public Program() {

    }

    public void addEvent(IEvent event) {
        events.add((Event)event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getProgramName() {
        return name;
    }

    @Override
    public IEvent getEventByName(String eventName) {
        return this.events.stream().filter(event -> event.getEventName().equals(eventName)).findFirst().orElseThrow();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
