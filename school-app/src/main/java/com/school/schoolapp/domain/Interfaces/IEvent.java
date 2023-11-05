package com.school.schoolapp.domain.Interfaces;

import com.school.schoolapp.domain.abstractions.Person;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IEvent {
    boolean isOptional();
    List<Person> getAttendees();
    UUID getId();
    Date getStartDate();
    Date getEndDate();
    IClassroom getPlace();
    String getName();
    int getCapacity();
    IPerson addAttendee(IPerson attendees);
    IPerson getAttendee(IPerson attendee);
    void setStartDate(Date startDate) throws Exception;
    void setEndDate(Date endDate) throws Exception;
    void setPlace(IClassroom place);
    void setEventName(String name);
    void setCapacity(int capacity);
}