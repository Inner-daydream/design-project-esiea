package com.school.schoolapp.Application.Requests.school;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.School;

public class CreateSchoolRequest {
    @NotNull private String name;
    @NotNull private String address;
    @NotNull private String phoneNumber;

    @JsonCreator
    public CreateSchoolRequest(@JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("phoneNumber") String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public School getSchool(){
        return new School(name, address, phoneNumber);
    }
}
