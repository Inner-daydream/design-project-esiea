package com.school.schoolapp.Application.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Admin;

import javax.validation.constraints.NotNull;

public class CreateAdminRequest {

    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;
    @NotNull private int salary;

    @JsonCreator
    public CreateAdminRequest(@JsonProperty("name") String name, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("address") String address, @JsonProperty("schoolID") String schoolID, @JsonProperty("salary") int salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.schoolID = schoolID;
        this.salary = salary;
    }
    public Admin getAdmin(){
        return new Admin(name, phoneNumber, address, null, salary);
    }
}
