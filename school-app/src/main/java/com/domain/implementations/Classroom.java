package com.domain.implementations;

import com.domain.Interfaces.IClassroom;

public class Classroom implements IClassroom {
    private String name;
    private String buildingName;
    private int capacity;

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
}

