package com.school.schoolapp.Application.Requests.classroom;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Classroom;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateClassroomRequest {
    @NotNull private String id;
    @NotNull private String name;
    @NotNull private String buildingName;
    @NotNull private int capacity;

    @JsonCreator
    public UpdateClassroomRequest(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("buildingName") String buildingName,
            @JsonProperty("capacity") int capacity
    ) {
        this.id = id;
        this.name = name;
        this.buildingName = buildingName;
        this.capacity = capacity;
    }

    public Classroom getClassroom(){
        return new Classroom(name, buildingName, capacity, UUID.fromString(id));
    }
}
