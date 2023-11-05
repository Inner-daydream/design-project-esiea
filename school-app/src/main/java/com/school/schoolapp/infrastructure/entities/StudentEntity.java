package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    private String ID;
    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private int lunchCredit;

    public StudentEntity() {
    }

    public String getID() {
        return ID;
    }

    public StudentEntity(Student student) {
        this.ID = student.getId().toString();
        this.person = new PersonEntity(student);
        this.lunchCredit = student.getLunchCredit();
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

    public int getLunchCredit() {
        return lunchCredit;
    }
}
