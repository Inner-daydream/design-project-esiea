package com.school.schoolapp.Application.Requests.Program;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.implementations.Program;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class UpdateProgramRequest {
    private String name;
    @NotNull private String id;
    @NotNull private List<String> events;

    @JsonCreator
    public UpdateProgramRequest(@JsonProperty("name") String name, @JsonProperty("id") String id, @JsonProperty("events") List<String> events) {
        this.name = name;
        this.id = id;
        this.events = events;
    }

    public Program getProgram(List<Event> events){
        return new Program(UUID.fromString(id), name, events);
    }

    public List<String> getEvents() {
        return events;
    }
}
