package com.school.schoolapp.infrastructure.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.abstractions.Event;
@Entity
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

    public PersonEntity(Person person) {
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
