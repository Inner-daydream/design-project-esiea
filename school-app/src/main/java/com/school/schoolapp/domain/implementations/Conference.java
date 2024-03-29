package com.school.schoolapp.domain.implementations;

import java.util.Date;
import java.util.List;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;



public class Conference extends Event {
    private Person speaker;
    public Conference(String name, Classroom classroom, Date startDate, Date endDate, List<Student> students, int capacity, boolean isOptional, IPerson speaker) {
        super(name, classroom, startDate, endDate, students, capacity, isOptional);
        this.speaker = (Person) speaker;
    }
    public Person getSpeaker() {
        return speaker;
    }

     @Override
     public Person getTeacher() throws Exception {
         return null;
     }
 }
