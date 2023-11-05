package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GradeEvent {
    private IEvent event;
    private IPerson person;

    private List<Float> grades;
    private UUID id;

    public GradeEvent(IEvent event, IPerson person) {
        this.event = event;
        this.person = person;
        this.grades = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public GradeEvent() {

    }

    public List<Float> getGrades() {
        return grades;
    }

    public IPerson getPerson() {
        return person;
    }

    public IEvent getEvent() {
        return event;
    }

    public void addGrade(float grade) {
        grades.add(grade);
    }

    public float getAverage() {
        if (grades.isEmpty()) {
            return 0.0f; // Return 0 if there are no grades.
        }

        float sum = 0.0f;
        for (float grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }


    public UUID getId() {
        return id;
    }
}