package com.school.schoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table
@Embeddable
public class Classroom {
    @Id
    @SequenceGenerator(
            name = "classroom_sequence",
            sequenceName = "classroom_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classroom_sequence"
    )
    private Long id;
    private String name;
    private String buildingName;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Classroom() {
        this.id = 0L;
        this.name = "";
        this.buildingName = "";
        this.capacity = 0;
    }

    public Classroom(String name, String buildingName, int capacity, School school) {
        this.name = name;
        this.buildingName = buildingName;
        this.capacity = capacity;
        this.school = school;
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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
        school.addClassroom(this);
    }
}
