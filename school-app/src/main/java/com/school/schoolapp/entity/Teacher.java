package com.school.schoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table
@Embeddable
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private int salary;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


    public Teacher(String name, String phoneNumber, String address, School school, int salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.school = school;
        this.salary = salary;
    }

    public Teacher() {
        this.id = 0L;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
        this.salary = 0;
    }

    public Long getSchoolId() {
        return school.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
