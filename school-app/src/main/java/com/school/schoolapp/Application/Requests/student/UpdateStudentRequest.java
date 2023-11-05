package com.school.schoolapp.Application.Requests.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Student;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateStudentRequest {
    @NotNull private String id;
    @NotNull private int lunchCredit;
    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;

    @JsonCreator
    public UpdateStudentRequest(
            @JsonProperty("id") String id,
            @JsonProperty("lunchCredit") int lunchCredit,
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("address") String address,
            @JsonProperty("schoolID") String schoolID
    ) {
        this.id = id;
        this.lunchCredit = lunchCredit;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.schoolID = schoolID;
    }

    public Student getStudent(){
        return new Student(UUID.fromString(id), name, phoneNumber, address, lunchCredit, UUID.fromString(schoolID));
    }
}
