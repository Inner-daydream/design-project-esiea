package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student extends Person {
    private List<GradeEvent> grades;
    private int lunchCredit;

    public Student(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        lunchCredit = 0;
        grades = new ArrayList<>();
    }

    public Student(String name, String phoneNumber, String address, int lunchCredit, UUID schoolID) {
        super(name, phoneNumber, address, schoolID);
        this.lunchCredit = lunchCredit;
        grades = new ArrayList<>();
    }

    public int getLunchCredit() {
        return lunchCredit;
    }
    public void AddGrades(IEvent event, float grade){
        if(grades.stream().anyMatch(igrade -> igrade.getEvent().equals(event))){
            GradeEvent res = grades.stream().filter(gr -> gr.getEvent().equals(event)).findFirst().orElseThrow();
            res.addGrade(grade);
        }else{
            var ge = new GradeEvent((Event)event, this);
            ge.addGrade(grade);
            grades.add(ge);
        }
    }

    public void setLunchCredit(int lunchCredit) {
        this.lunchCredit = lunchCredit;
    }

    public void applyToProgram(String programName) {

    }

}

