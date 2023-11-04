package com.school.schoolapp.infrastructure.entities;

import java.util.Date;
import java.util.List;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
@Entity
@Table(name = "event")
public class EventEntity {
    private String name;
    @OneToOne
    @JoinColumn(name = "classroom_id")
    private ClassroomEntity classroom;
    private Date startDate;
    private Date endDate;
    @ManyToMany
    @JoinTable(name = "person_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<PersonEntity> students;
    private int capacity;
    private boolean isOptional;
    
    @Id
    private String id;

    public EventEntity() {
    }
    public EventEntity(Event event) {
        this.name = event.getName();
        this.classroom = new ClassroomEntity(event.getClassroom());
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.capacity = event.getCapacity();
        this.isOptional = event.isOptional();
        this.id = event.getId().toString();
        for (Person person : event.getStudents()) {
            this.students.add(new PersonEntity(person));
        }
    }

}
