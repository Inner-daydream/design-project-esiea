package com.school.schoolapp.Application.Requests.conference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.Interfaces.IPerson;
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
    private String classroomID;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private List<String> studentsIDs;
    @NotNull
    private int capacity;
    @NotNull
    private boolean isOptional;
    @NotNull
    private String speakerID;


    @JsonCreator
    public CreateConferenceRequest(@JsonProperty("name") String name, @JsonProperty("classroomID") String classroomID, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("studentsIDs") List<String> students, @JsonProperty("capacity") int capacity, @JsonProperty("isOptional") boolean isOptional, @JsonProperty("speaker") String speakerID) {
        this.name = name;
        this.classroomID = classroomID;
        this.studentsIDs = students;
        this.startDate = new Date(Long.parseLong(startDate) * 1000);
        this.endDate = new Date(Long.parseLong(endDate) * 1000);
        this.capacity = capacity;
        this.isOptional = isOptional;
        this.speakerID = speakerID;
    }
    
    public Conference getConference(List<Student> students, IPerson speaker, Classroom classroom) {
        return new Conference(name, classroom, startDate, endDate, students, capacity, isOptional, speaker);
    }
    public String getSpeakerID() {
        return speakerID;
    }
    public List<String> getStudentsIDs() {
        return studentsIDs;
    }
    public String getClassroomID() {
        return classroomID;
    }

}
