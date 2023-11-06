package com.school.schoolapp.Application.response.course;

import com.school.schoolapp.domain.implementations.Course;

import java.util.List;

public class GetAllCourseResponse {
    List<Course> courses;

    public GetAllCourseResponse(List<Course> courses) {
        this.courses = courses;
    }
}
