package com.school.schoolapp.Application.response.teacher;

import com.school.schoolapp.domain.implementations.Teacher;
import java.util.List;
public class GetAllTeachersResponse {
    
    private List<Teacher> teachers;

    public GetAllTeachersResponse(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public List<Teacher> getTeachers() {
        return this.teachers;
    }
}
