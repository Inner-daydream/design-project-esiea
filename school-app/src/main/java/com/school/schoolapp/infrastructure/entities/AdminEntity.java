package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.implementations.Admin;
import jakarta.persistence.*;

import java.util.UUID;

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
        return person.getSchoolID();
    }
    public int getSalary() {
        return salary;
    }
}
