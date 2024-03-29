package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.implementations.Teacher;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    private String ID;
    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private int salary;

    public TeacherEntity() {
    }

    public String getID() {
        return ID;
    }

    public TeacherEntity(Teacher teacher) {
        this.ID = teacher.getId().toString();
        this.person = new PersonEntity(teacher);
        this.salary = teacher.getSalary();
    }
    public String getName() {
        return person.getName();
    }
    public String getPhoneNumber() {
        return person.getPhoneNumber();
    }
    public String getAddress() {
        return person.getAddress();
    }
    public String getSchoolID() {
        return person.getSchoolID();
    }
    public int getSalary() {
        return salary;
    }
}
