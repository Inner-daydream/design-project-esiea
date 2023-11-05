package com.school.schoolapp.infrastructure.entities;

import com.school.schoolapp.domain.Interfaces.IClassroom;
import com.school.schoolapp.domain.implementations.Classroom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "classroom")
public class ClassroomEntity {
    private String name;
    private String buildingName;
    private int capacity;
    @Id
    private String id;

    public ClassroomEntity() {
    }

    public ClassroomEntity(IClassroom classroom) {
        this.name = classroom.getName();
        this.buildingName = classroom.getBuildingName();
        this.capacity = classroom.getCapacity();
        this.id = classroom.getId().toString();
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

    public String getId() {
        return id;
    }

    public Classroom toClassroom() {
        return new Classroom(this.name, this.buildingName, this.capacity);
    }
}
