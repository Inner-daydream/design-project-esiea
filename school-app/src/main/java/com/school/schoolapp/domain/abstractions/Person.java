package com.school.schoolapp.domain.abstractions;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.School;
import com.school.schoolapp.domain.Interfaces.IEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public abstract class Person implements IPerson {
    private String name;
    private String phoneNumber;
    private String address;
    private School school;
    private List<Event> events;

    private Long id;

    public Person(String name, String phoneNumber, String address, School school) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.school = school;
        this.events = new ArrayList<>();
    }

    public Person() {

    }

    @Override
    public IEvent getEvent(IEvent event){
        return events.stream().filter(ievent -> ievent.getEventName().equals(event.getEventName())).findFirst().orElseThrow();
    }
    @Override
    public School getSchool() {
        return this.school;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}