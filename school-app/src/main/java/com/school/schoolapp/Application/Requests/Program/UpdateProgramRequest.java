package com.school.schoolapp.Application.Requests.Program;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Program;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class UpdateProgramRequest {
    @NotNull private String name;
    @NotNull private String id;
    @NotNull private List<Event> events;

    @JsonCreator
    public UpdateProgramRequest(@JsonProperty("name") String name, @JsonProperty("id") String id, @JsonProperty("events") List<Event> events) {
        this.name = name;
        this.id = id;
        this.events = events;
    }

    public Program getProgram(){
        return new Program(UUID.fromString(id), name, events);
    }
}
