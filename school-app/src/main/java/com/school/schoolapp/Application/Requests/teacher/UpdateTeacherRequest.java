package com.school.schoolapp.Application.Requests.teacher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Teacher;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateTeacherRequest {
    @NotNull private String id;
    @NotNull private int salary;
    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;

    @JsonCreator
    public UpdateTeacherRequest(
            @JsonProperty("id") String id,
            @JsonProperty("salary") int salary,
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("address") String address,
            @JsonProperty("schoolID") String schoolID
    ) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.schoolID = schoolID;
    }

    public Teacher getTeacher(){
        return new Teacher(UUID.fromString(id), name, phoneNumber, address, salary, UUID.fromString(schoolID));
    }
}
