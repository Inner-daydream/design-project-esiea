package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.abstractions.Event;
import com.domain.abstractions.Person;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@MappedSuperclass
public class Student extends Person {
    @OneToMany
    private List<GradeEvent> grades;
    private int lunchCredit;

    public Student(String name, String phoneNumber, String address, School school) {
        super(name, phoneNumber, address, school);
        lunchCredit = 0;
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

