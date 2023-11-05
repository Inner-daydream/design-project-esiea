package com.school.schoolapp.Application.Requests.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Student;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateStudentRequest {
    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;
    @NotNull private int lunchCredit;

    @JsonCreator
    public CreateStudentRequest(@JsonProperty("name") String name, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("address") String address, @JsonProperty("schoolID") String schoolID, @JsonProperty("lunchCredit") int lunchCredit) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.schoolID = schoolID;
        this.lunchCredit = lunchCredit;
    }

    public Student getStudent(){
        return new Student(name, phoneNumber, address, lunchCredit, UUID.fromString(this.schoolID));
    }
}
