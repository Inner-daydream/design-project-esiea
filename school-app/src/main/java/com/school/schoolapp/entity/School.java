package com.school.schoolapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Embeddable

public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(name = "Schools_admins")
    private List<Admin> admins;

    @ElementCollection
    @CollectionTable(name = "Schools_teachers")
    private List<Teacher> teachers;

    @ElementCollection
    @CollectionTable(name = "Schools_students")
    private List<Student> students;

    @ElementCollection
    @CollectionTable(name = "Schools_classrooms")
    private List<Classroom> classrooms;

    @Transient
    private int numberOfClasses;
    @Transient
    private int numberOfStudents;
    @Transient
    private int numberOfTeachers;
    @Transient
    private int numberOfAdmins;

    public School() {
        this.id = 0L;
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public School(String name, String address, String phoneNumber, List<Admin> admins, List<Teacher> teachers, List<Student> students, List<Classroom> classrooms) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.admins = admins;
        this.teachers = teachers;
        this.students = students;
        this.classrooms = classrooms;
    }

    public int getNumberOfClasses() {
        return this.classrooms.size();
    }

    public int getNumberOfStudents() {
        return this.students.size();
    }

    public int getNumberOfTeachers() {
        return this.teachers.size();
    }

    public int getNumberOfAdmins() {
        return this.admins.size();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
