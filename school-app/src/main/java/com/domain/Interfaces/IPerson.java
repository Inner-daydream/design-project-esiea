package com.domain.Interfaces;

import com.domain.implementations.School;

import java.util.List;

public interface IPerson {
    String getID();
    String getName();
    String getPhoneNumber();
    String getAddress();
    List<IEvent> getEvents();
    School getSchool();

    void SetID(String id);
    void setName(String name);
    void setPhoneNumber(String phoneNumber);
    void setAddress(String address);
    void addEvent(IEvent event);
    void removeEvent(int eventIndex);
    IEvent getEvent(IEvent event);
}
