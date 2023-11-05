package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.implementations.School;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import com.school.schoolapp.domain.abstractions.Person;

@Entity
@Table(name = "school")
public class SchoolEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    public SchoolEntity() {
    }

    public SchoolEntity(School school) {
        this.id = school.getId().toString();
        this.name = school.getName();
        this.address = school.getAddress();
        this.phoneNumber = school.getPhoneNumber();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
