package com.school.schoolapp.domain.Interfaces;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Student;

public interface IEvent {
    boolean isOptional();
    List<Student> getAttendees();
    UUID getId();
    Date getStartDate();

    // Person getTeacher() throws Exception;
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