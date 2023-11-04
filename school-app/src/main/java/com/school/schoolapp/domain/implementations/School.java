package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IProgram;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.Interfaces.IEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class School {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Person> people;
    // private List<Program> programs;

    private UUID id;

    public School(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.people = new ArrayList<>();
        this.id = UUID.randomUUID();
        // this.programs = new ArrayList<>();
    }

    public School() {

    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    // public IProgram getProgram(String programName){
    //     return this.programs.stream().filter(prog -> prog.getProgramName().equals(programName)).findFirst().orElseThrow();
    // }
    // public void addProgram(Program program){
    //     this.programs.add(program);
    // }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // public IEvent getEvent(String eventName) {
    //     return programs.stream().filter(iProgram -> {
    //         try{
    //             iProgram.getEventByName(eventName);
    //             return true;
    //         }catch(Exception ex){
    //             return false;
    //         }
    //     }).findFirst().orElseThrow().getEventByName(eventName);
    // }
    public List<Person> getPeople() {
        return people;
    }
    public UUID getId() {
        return id;
    }
}
