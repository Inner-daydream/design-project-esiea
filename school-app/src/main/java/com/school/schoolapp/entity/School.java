package com.school.schoolapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "schools")

public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "school")
    private List<Admin> admins;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school")
    private List<Student> students;

    @OneToMany(mappedBy = "school")
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

    public School(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }
}
