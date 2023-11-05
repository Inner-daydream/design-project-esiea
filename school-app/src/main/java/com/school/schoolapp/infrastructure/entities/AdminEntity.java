package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Admin;
import jakarta.persistence.*;

@Entity
public class AdminEntity {
    @Id
    private String ID;
    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private int salary;

    public AdminEntity() {
    }

    public AdminEntity(Admin admin) {
        this.ID = admin.getId().toString();
        this.person = new PersonEntity(admin);
        this.salary = admin.getSalary();
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
        return person.getSchool().getId();
    }
    public int getSalary() {
        return salary;
    }
}
