package com.domain.Interfaces;

public interface IClassroom {
    String getID();
    String getName();
    String getBuildingName();

    void setID(String id);
    int getCapacity();

    void setCapacity(int capacity);
    void setName(String name);
    void setBuildingName(String buildingName);
}
