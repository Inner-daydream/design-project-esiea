package com.school.schoolapp.domain.abstractions;

import com.school.schoolapp.domain.Interfaces.IClassroom;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.Interfaces.IEvent;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class Event implements IEvent {
    private String name;
    private Classroom classroom;
    private Date startDate;
    private Date endDate;
    private List<Person> students;
    private int capacity;
    private boolean isOptional;
    private UUID id;

    public Event(String name, Classroom classroom, Date startDate, Date endDate, List<Person> students, int capacity, boolean isOptional){
        this.name = name;
        this.classroom = classroom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.capacity = capacity;
        this.isOptional = isOptional;
        this.id = UUID.randomUUID();
    }
    public Classroom getClassroom() {
        return classroom;
    }
    public List<Person> getStudents() {
        return students;
    }
    public boolean isOptional() {
        return isOptional;
    }
    public boolean isEventOptional(){
        return isOptional;
    };
    public List<Person> getAttendees(){
        return students;
    };
    public Date getStartDate(){
        return startDate;
    };
    public Date getEndDate(){
        return endDate;
    };
    public IClassroom getPlace(){
        return classroom;
    };
    public String getName(){
        return name;
    };
    public int getCapacity(){
        return capacity;
    };

    public IPerson addAttendee(IPerson attendee){
        try{
            return attendee;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public IPerson getAttendee(IPerson attendee) {
        this.getAttendees().stream().filter(iPerson -> iPerson.equals(attendee));
        return null;
    }

    public void setStartDate(Date startDate) throws Exception {
        if(startDate.after(endDate)){
            throw new Exception("start date is after end date");
        }
        this.startDate = startDate;
    };
    public void setEndDate(Date endDate) throws Exception {
        if(endDate.before(startDate)){
            throw new Exception("End date is before start date");
        }
        this.endDate = endDate;
    };
    public void setPlace(IClassroom place){
        this.classroom = (Classroom) place;
    };
    public void setEventName(String name){
        this.name = name;
    };
    public void setCapacity(int capacity){
        this.capacity = capacity;
    };

    @Override
    public UUID getId() {
        return id;
    }
}
