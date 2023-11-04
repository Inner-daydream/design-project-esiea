package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Table
@Entity
public class GradeEvent {
    @OneToOne
    private Event event;
    @OneToOne
    private Person person;
    @ElementCollection
    @CollectionTable(
            name = "grade_event_grades", // You can specify the name of the table for grades
            joinColumns = @JoinColumn(name = "grade_event_id") // Define a foreign key column
    )
    @Column(name = "grade")
    private List<Float> grades;
    @Id
    @SequenceGenerator(
            name = "_sequenceGrade",
            sequenceName = "_sequenceGrade",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "_sequenceGrade"
    )
    private Long id;

    public GradeEvent(Event event, Person person) {
        this.event = event;
        this.person = person;
        this.grades = new ArrayList<>();
    }

    public GradeEvent() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}