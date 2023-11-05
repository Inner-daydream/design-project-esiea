package com.school.schoolapp.domain.Interfaces;

import java.util.UUID;

public interface IClassroom {
    String getName();
    String getBuildingName();
    int getCapacity();
    UUID getId();
    void setCapacity(int capacity);
    void setName(String name);
    void setBuildingName(String buildingName);
}
