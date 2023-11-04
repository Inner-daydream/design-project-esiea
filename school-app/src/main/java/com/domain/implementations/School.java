package com.domain.implementations;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.domain.Interfaces.*;
import com.domain.abstractions.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
@Entity
@Table
public class School {
    private String name;
    private String address;
    private String phoneNumber;
    @OneToMany
    private List<Person> people;
    @OneToMany
    private List<Program> programs;
    @Id
    @SequenceGenerator(
            name = "_sequenceSchool",
            sequenceName = "_sequenceSchool",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "_sequenceSchool"
    )
    private Long id;

    public School(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.people = new ArrayList<>();
        this.programs = new ArrayList<>();
    }

    public School() {

    }

    public String getSchoolName() {
        return name;
    }
    public String getSchoolAddress() {
        return address;
    }
    public IProgram getProgram(String programName){
        return this.programs.stream().filter(prog -> prog.getProgramName().equals(programName)).findFirst().orElseThrow();
    }
    public void addProgram(Program program){
        this.programs.add(program);
    }
    public String getSchoolPhoneNumber() {
        return phoneNumber;
    }
    public IEvent getEvent(String eventName) {
        return programs.stream().filter(iProgram -> {
            try{
                iProgram.getEventByName(eventName);
                return true;
            }catch(Exception ex){
                return false;
            }
        }).findFirst().orElseThrow().getEventByName(eventName);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
