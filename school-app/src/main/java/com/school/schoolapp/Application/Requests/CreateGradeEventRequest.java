package com.school.schoolapp.Application.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CreateGradeEventRequest {
    @NotNull
    private String eventId;
    @NotNull
    private String personId;
    @NotNull
    private float grade;
    @JsonCreator
    public CreateGradeEventRequest(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("personId") String personId,
            @JsonProperty("grade")float grade) {
        this.eventId = eventId;
        this.personId = personId;
        this.grade = grade;
    }

    public String getEventId() {
        return eventId;
    }

    public String getPersonId() {
        return personId;
    }

    public float getGrade() {
        return grade;
    }
}
