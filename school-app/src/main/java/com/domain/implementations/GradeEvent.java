package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.Interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class GradeEvent {
    private IEvent event;
    private IPerson person;
    private List<Float> grades;

    public GradeEvent(IEvent event, IPerson person) {
        this.event = event;
        this.person = person;
        this.grades = new ArrayList<>();
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
}