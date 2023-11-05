package com.school.schoolapp.infrastructure.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
@Entity
@Table(name = "event")
public class EventEntity {
    private String name;
    @OneToOne
    @JoinColumn(name = "classroom_id")
    private ClassroomEntity classroom;
    private Date startDate;
    private Date endDate;
    @ManyToMany
    @JoinTable(name = "person_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<PersonEntity> attendees;
    private int capacity;
    private boolean isOptional;
    
    @Id
    private String id;

    public EventEntity() {
    }
    public EventEntity(IEvent event) {
        this.name = event.getName();
        this.classroom = new ClassroomEntity(event.getPlace());
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.capacity = event.getCapacity();
        this.isOptional = event.isOptional();
        this.id = event.getId().toString();
        for (IPerson person : event.getAttendees()) {
            this.attendees.add(new PersonEntity(person));
        }
    }
}
