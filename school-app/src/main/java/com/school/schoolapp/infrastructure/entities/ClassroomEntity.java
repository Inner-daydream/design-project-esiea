package com.school.schoolapp.infrastructure.entities;

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

    public ClassroomEntity(Classroom classroom) {
        this.name = classroom.getName();
        this.buildingName = classroom.getBuildingName();
        this.capacity = classroom.getCapacity();
        this.id = classroom.getId().toString();
    }
}
