package com.school.schoolapp.infrastructure.entities;

import java.util.List;

import com.school.schoolapp.domain.implementations.School;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.abstractions.Event;

@Entity
public class PersonEntity {
    private String name;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
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
        this.school = new SchoolEntity(person.getSchool());
        this.id = person.getId().toString();
        for (Event eventEntity : person.getEvents()) {
            this.events.add(new EventEntity(eventEntity));
        }

    }

    public SchoolEntity getSchool() {
        return school;
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
}
