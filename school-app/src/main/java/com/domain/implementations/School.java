package com.domain.implementations;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.domain.Interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class School {
    private String name;
    private String address;
    private String phoneNumber;
    private List<IPerson> people;
    private List<IProgram> programs;

    public School(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.people = new ArrayList<>();
        this.programs = new ArrayList<>();
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
}
