package com.school.schoolapp.domain.Interfaces;

public interface IClassroom {
    String getName();
    String getBuildingName();
    int getCapacity();

    void setCapacity(int capacity);
    void setName(String name);
    void setBuildingName(String buildingName);
}
