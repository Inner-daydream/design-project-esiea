package com.school.schoolapp.Application.Requests.school;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.School;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class UpdateSchoolRequest {
    @NotNull private String name;
    @NotNull private String address;
    @NotNull private String phoneNumber;
    @NotNull private String id;

    @JsonCreator
    public UpdateSchoolRequest(@JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("id") String id) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public School getSchool(){
        return new School(UUID.fromString(id), name, address, phoneNumber);
    }
}
