package com.school.schoolapp.Application.response.classroom;

import com.school.schoolapp.domain.implementations.Classroom;
import java.util.List;
public class GetAllClassroomResponse {
    private List<Classroom> classrooms;

    public GetAllClassroomResponse(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
    public List<Classroom> getClassrooms() {
        return this.classrooms;
    }
}
