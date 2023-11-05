package com.school.schoolapp.Application.Requests.teacher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Teacher;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateTeacherRequest {
    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;
    @NotNull private int salary;

    @JsonCreator
    public CreateTeacherRequest(@JsonProperty("name") String name, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("address") String address, @JsonProperty("schoolID") String schoolID, @JsonProperty("salary") int salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.schoolID = schoolID;
        this.salary = salary;
    }

    public Teacher getTeacher(){
        return new Teacher(name, phoneNumber, address, salary, UUID.fromString(this.schoolID));
    }
}
