package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Program;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "program")
public class ProgramEntity {
    @Id
    private String id;
    private String name;
    @ManyToMany
    @JoinTable(name = "program_event", joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;
    public ProgramEntity() {
    }
    public ProgramEntity(Program program) {
        this.id = program.getId().toString();
        this.name = program.getProgramName();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }


}
