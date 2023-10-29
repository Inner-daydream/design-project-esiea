package com.school.schoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table
@Embeddable
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Admin(String name, String phoneNumber, String address, School school) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.school = school;
    }

    public Admin() {
        this.id = 0L;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    public String getName() {
        return name;
    }

   public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSchoolId() {
        return 0L;//this.school.getId();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
