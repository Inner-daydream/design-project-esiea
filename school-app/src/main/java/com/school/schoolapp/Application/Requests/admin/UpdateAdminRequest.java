package com.school.schoolapp.Application.Requests.admin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.implementations.Admin;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateAdminRequest {
    @NotNull private String id;
    @NotNull private int salary;
    @NotNull private String name;
    @NotNull private String phoneNumber;
    @NotNull private String address;
    @NotNull private String schoolID;

    @JsonCreator
    public UpdateAdminRequest(
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

    public Admin getAdmin(){
        return new Admin(UUID.fromString(id), name, phoneNumber, address, salary, UUID.fromString(schoolID));
    }
}
