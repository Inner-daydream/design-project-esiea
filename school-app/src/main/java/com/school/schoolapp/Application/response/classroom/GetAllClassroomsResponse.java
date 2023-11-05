package com.school.schoolapp.Application.response.classroom;

import com.school.schoolapp.domain.implementations.Classroom;
import java.util.List;
public class GetAllClassroomsResponse {
    private List<Classroom> classrooms;

    public GetAllClassroomsResponse(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
    public List<Classroom> getClassrooms() {
        return this.classrooms;
    }
}
