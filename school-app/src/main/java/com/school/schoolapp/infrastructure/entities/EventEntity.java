package com.school.schoolapp.infrastructure.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Student;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class EventEntity {
    private String name;
    @OneToOne
    @JoinColumn(name = "classroom_id")
    private ClassroomEntity classroom;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private PersonEntity personEntity;
    @ManyToMany
    @JoinTable(name = "person_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<PersonEntity> attendees;
    private int capacity;
    private boolean isOptional;
    
    @Id
    private String id;

    public EventEntity() {
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public EventEntity(IEvent event) {
        this.name = event.getName();
        this.classroom = new ClassroomEntity(event.getPlace());
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.capacity = event.getCapacity();
        this.isOptional = event.isOptional();
        this.id = event.getId().toString();
        try{
            this.personEntity = new PersonEntity((event.getTeacher()));

        }catch (Exception ex){
            this.personEntity = null;
        }
        this.attendees = new LinkedList<>();
        for (IPerson person : event.getAttendees()) {
            this.attendees.add(new PersonEntity(person));
        }
    }

    public List<PersonEntity> getAttendees() {
        return attendees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassroomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomEntity classroom) {
        this.classroom = classroom;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public void setOptional(boolean optional) {
        isOptional = optional;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
