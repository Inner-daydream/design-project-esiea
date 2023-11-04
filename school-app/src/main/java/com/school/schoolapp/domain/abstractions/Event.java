package com.school.schoolapp.domain.abstractions;

import com.school.schoolapp.domain.Interfaces.IClassroom;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.Interfaces.IEvent;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
@DiscriminatorColumn(name="EVENT_TYPE")
public abstract class Event implements IEvent {
    private String name;
    @ManyToOne
    private Classroom classroom;
    private Date startDate;
    private Date endDate;
    @ManyToMany
    private List<Person> students;
    private int capacity;
    private boolean isOptional;
    @Id
    @SequenceGenerator(
            name = "_sequenceEvent",
            sequenceName = "_sequenceEvent",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "_sequenceEvent"
    )
    private Long id;

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
        this.classroom = (Classroom) place;
    };
    public void setEventName(String name){
        this.name = name;
    };
    public void setCapacity(int capacity){
        this.capacity = capacity;
    };

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
