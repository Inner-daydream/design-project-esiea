package com.domain.abstractions;

import com.domain.Interfaces.*;

import java.util.Date;
import java.util.List;

public abstract class Event implements IEvent {

    private String Id;
    private String name;
    private IClassroom classroom;
    private Date startDate;
    private Date endDate;
    private List<IPerson> students;
    private int capacity;
    private boolean isOptional;

    public Event(String id, String name, IClassroom classroom, Date startDate, Date endDate, List<IPerson> students, int capacity, boolean isOptional) {
        this.Id = id;
        this.name = name;
        this.classroom = classroom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.capacity = capacity;
        this.isOptional = isOptional;
    }

    @Override
    public String getID() {
        return this.Id;
    }

    @Override
    public void setID(String id) {
        this.Id = id;
    }
    public boolean isEventOptional(){
        return isOptional;
    };
    public List<IPerson> getAttendees(){
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
    public String getEventName(){
        return name;
    };
    public int getEventCapacity(){
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
        this.classroom = place;
    };
    public void setEventName(String name){
        this.name = name;
    };
    public void setCapacity(int capacity){
        this.capacity = capacity;
    };
}
