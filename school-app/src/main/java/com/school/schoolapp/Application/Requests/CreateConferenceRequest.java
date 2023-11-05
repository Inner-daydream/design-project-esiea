package com.school.schoolapp.Application.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Admin;
import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Student;

import java.sql.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
public class CreateConferenceRequest {

    @NotNull
    private String name;
    @NotNull
    private String classroom;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private List<String> students;
    @NotNull
    private int capacity;
    @NotNull
    private boolean isOptional;
    @NotNull
    private String speaker;


    @JsonCreator
    public CreateConferenceRequest(@JsonProperty("name") String name, @JsonProperty("classroomID") String classroomID, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("studentsIDs") List<String> students, @JsonProperty("capacity") int capacity, @JsonProperty("isOptional") boolean isOptional, @JsonProperty("speaker") String speaker) {
        this.name = name;
        this.classroom = classroomID;
        this.startDate = Date.valueOf(startDate);
        this.endDate = Date.valueOf(endDate);
        this.capacity = capacity;
        this.isOptional = isOptional;
        this.speaker = speaker;
    }
    
    public Conference getConference(List<Person> students, Person speaker, Classroom classroom) {
        return new Conference(name, classroom, startDate, endDate, students, capacity, isOptional, speaker);
    }
    public String getSpeakerID() {
        return speaker;
    }
    public List<String> getStudentsIDs() {
        return students;
    }
    public String getClassroomID() {
        return classroom;
    }

}
