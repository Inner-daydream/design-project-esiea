package com.school.schoolapp.entity;

import jakarta.persistence.*;


@Entity
@Table
@Embeddable
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    //private School school;
    private int lunchCredit;
    private Long schoolId;

    public Student(String name, String phoneNumber, String address/*, School school*/, int lunchCredit) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        //this.school = school;
        this.lunchCredit = lunchCredit;
    }

    public Student() {
        this.id = 0L;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
        this.lunchCredit = 0;
    }

    public void getSchoolId() {
        this.schoolId = 0L;//school.getId();
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


    /*public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }*/

    public int getLunchCredit() {
        return lunchCredit;
    }

    public void setLunchCredit(int lunchCredit) {
        this.lunchCredit = lunchCredit;
    }
}
