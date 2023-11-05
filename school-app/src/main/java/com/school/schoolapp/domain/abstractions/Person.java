package com.school.schoolapp.domain.abstractions;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.School;
import com.school.schoolapp.domain.Interfaces.IEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Person implements IPerson {
    private String name;
    private String phoneNumber;
    private String address;
    private UUID schoolID;
    private List<Event> events;



    private UUID id;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.events = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.schoolID = null;
    }
    public Person(String name, String phoneNumber, String address, UUID schoolID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.events = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.schoolID = schoolID;
    }

    public Person() {

    }
    @Override
    public IEvent getEvent(IEvent event){
        return events.stream().filter(ievent -> ievent.getName().equals(event.getName())).findFirst().orElseThrow();
    }
    @Override
    public UUID  getSchoolID() {
        return this.schoolID;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getPhoneNumber(), person.getPhoneNumber()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber(), getAddress());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void addEvent(IEvent event) {
        events.add((Event) event);
    }

    @Override
    public void removeEvent(int eventIndex) {
        if (eventIndex >= 0 && eventIndex < events.size()) {
            events.remove(eventIndex);
        }
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
