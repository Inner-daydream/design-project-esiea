package com.domain.implementations;

import com.domain.Interfaces.IClassroom;

public class Classroom implements IClassroom {

    private String id;
    private String name;
    private String buildingName;
    private int capacity;


    public Classroom(String id, String name, String buildingName, int capacity) {
        this.id = id;
        this.name = name;
        this.buildingName = buildingName;
        this.capacity = capacity;
    }
    @Override
    public String getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getBuildingName() {
        return buildingName;
    }

    @Override
    public void setID(String id) { this.id = id; }

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

