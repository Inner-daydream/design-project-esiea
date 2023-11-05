package com.school.schoolapp.infrastructure.entities;

import java.util.List;
import java.util.UUID;

import com.school.schoolapp.domain.Interfaces.IPerson;
import jakarta.persistence.*;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.abstractions.Event;
@Entity
@Table(name = "person")
public class PersonEntity {
    private String name;
    private String phoneNumber;
    private String address;
    @Column(name = "school_id")
    private String schoolID;
    @ManyToMany
    @JoinTable(name = "person_event", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;

    @Id
    private String id;

    public PersonEntity() {
    }

    public PersonEntity(IPerson person) {
        this.name = person.getName();
        this.phoneNumber = person.getPhoneNumber();
        this.address = person.getAddress();
        this.schoolID = person.getSchoolID().toString();
        this.id = person.getId().toString();
        for (Event eventEntity : person.getEvents()) {
            this.events.add(new EventEntity(eventEntity));
        }

    }

    public String getSchoolID() {
        return schoolID;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setSchoolID(String id) {
        this.schoolID = id;
    }
}
