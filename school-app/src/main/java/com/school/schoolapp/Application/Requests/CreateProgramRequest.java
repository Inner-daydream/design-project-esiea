package com.school.schoolapp.Application.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Program;

import javax.validation.constraints.NotNull;

public class CreateProgramRequest {
    @NotNull private String name;

    @JsonCreator
    public CreateProgramRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Program getProgram(){
        return new Program(name);
    }
}
