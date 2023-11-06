package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Program;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "program")
public class ProgramEntity {
    @Id
    private String id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "program_event" , joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;
    public ProgramEntity() {
    }
    public ProgramEntity(Program program) {
        this.id = program.getId().toString();
        this.name = program.getProgramName();
        this.events = new LinkedList<>();
        program.getEvents().forEach(event -> {
            events.add(new EventEntity(event));
        });
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public List<EventEntity> getEvents() {
        if(events == null){
            return new LinkedList<>();
        }
        return events;
    }
}
