package com.school.schoolapp.domain.Interfaces;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.School;

import java.util.List;

public interface IPerson {
    String getName();
    String getPhoneNumber();
    String getAddress();
    List<Event> getEvents();
    School getSchool();
    void setName(String name);
    void setPhoneNumber(String phoneNumber);
    void setAddress(String address);
    void addEvent(IEvent event);
    void removeEvent(int eventIndex);
    IEvent getEvent(IEvent event);
}
