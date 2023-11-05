package com.school.schoolapp.domain.Interfaces;

import com.school.schoolapp.domain.abstractions.Event;

import java.util.List;
import java.util.UUID;

public interface IPerson {
    String getName();
    String getPhoneNumber();
    String getAddress();
    List<Event> getEvents();
    UUID getSchoolID();
    void setName(String name);
    void setPhoneNumber(String phoneNumber);
    void setAddress(String address);

    void addEvent(IEvent event);
    void removeEvent(int eventIndex);
    IEvent getEvent(IEvent event);

    UUID getId();
}
