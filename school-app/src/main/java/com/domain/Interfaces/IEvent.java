package com.domain.Interfaces;

import com.domain.abstractions.Person;

import java.util.Date;
import java.util.List;

public interface IEvent {
    boolean isEventOptional();
    List<Person> getAttendees();

    Date getStartDate();
    Date getEndDate();
    IClassroom getPlace();
    String getEventName();
    int getEventCapacity();
    IPerson addAttendee(IPerson attendees);
    IPerson getAttendee(IPerson attendee);
    void setStartDate(Date startDate) throws Exception;
    void setEndDate(Date endDate) throws Exception;
    void setPlace(IClassroom place);
    void setEventName(String name);
     void setCapacity(int capacity);
}