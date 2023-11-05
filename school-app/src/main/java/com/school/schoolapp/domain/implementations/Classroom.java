package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IClassroom;

import java.util.UUID;

public class Classroom implements IClassroom {
    private String name;
    private String buildingName;
    private int capacity;
    private UUID id;

    public Classroom(String name, String buildingName, int capacity){
        this.name = name;
        this.buildingName = buildingName;
        this.capacity = capacity;
        this.id = UUID.randomUUID();
    }

    public Classroom(String name, String buildingName, int capacity, UUID id){
        this.name = name;
        this.buildingName = buildingName;
        this.capacity = capacity;
        this.id = id;
    }

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


    public UUID getId() {
        return id;
    }
}

