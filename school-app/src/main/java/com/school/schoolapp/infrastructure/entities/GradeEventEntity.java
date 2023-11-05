package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.GradeEvent;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gradeEvent")
public class GradeEventEntity {
    @Id
    private String id;
    @OneToOne
    private EventEntity event;
    @OneToOne
    private PersonEntity person;
    @ElementCollection
    @CollectionTable(
            name = "grade_event_grades",
            joinColumns = @JoinColumn(name = "grade_event_id")
    )
    @Column(name = "grade")
    private List<Float> grades;

    public GradeEventEntity() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public EventEntity getEvent() {
        return event;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public List<Float> getGrades() {
        return grades;
    }

    public GradeEventEntity(GradeEvent gradeEvent){
            this.id = gradeEvent.getId().toString();
            this.event = new EventEntity(gradeEvent.getEvent());
            this.person = new PersonEntity(gradeEvent.getPerson());
            this.grades = gradeEvent.getGrades();
    }
}
