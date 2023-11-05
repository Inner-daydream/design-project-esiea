package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.implementations.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
    @OneToOne
    private EventEntity event;

    private boolean isExam;
    @OneToOne
    private PersonEntity teacher;
    @Id
    private String id;
    public CourseEntity(Course course){
        this.id = course.getId().toString();
        this.isExam = course.isExam();
        // try {
        //     this.teacher = new PersonEntity(course.getTeacher());
        // } catch (Exception e) {
        //     this.teacher = null;
        // }
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
