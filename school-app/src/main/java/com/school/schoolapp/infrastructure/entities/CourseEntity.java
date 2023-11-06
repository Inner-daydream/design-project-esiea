package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.implementations.Course;
import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class CourseEntity {
    @ManyToOne
    private EventEntity event;

    private boolean isExam;
    @ManyToOne
    private PersonEntity teacher;
    @Id
    private String id;
    public CourseEntity(Course course){
        this.id = course.getId().toString();
        this.event = new EventEntity(course);
        this.isExam = course.isExam();
        try {
             this.teacher = new PersonEntity(course.getTeacher());
        } catch (Exception e) {
            this.teacher = null;
        }
    }

    public CourseEntity() {

    }

    public EventEntity getEvent() {
        return event;
    }

    public boolean isExam() {
        return isExam;
    }

    public PersonEntity getTeacher() {
        return teacher;
    }

    public String getId() {
        return id;
    }
}
