package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IClassroom;

public class Classroom implements IClassroom {
    private String name;
    private String buildingName;
    private int capacity;
    private Long id;

    public String getName() {
        return name;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

