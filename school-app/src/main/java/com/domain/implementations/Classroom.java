package com.domain.implementations;

import com.domain.Interfaces.IClassroom;
import jakarta.persistence.*;

@Entity
@Table
public class Classroom implements IClassroom {
    private String name;
    private String buildingName;
    private int capacity;
    @Id
    @SequenceGenerator(
            name = "_sequenceClass",
            sequenceName = "_sequenceClass",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "_sequenceClass"
    )
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

