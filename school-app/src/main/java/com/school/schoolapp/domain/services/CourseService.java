package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Course;

import java.util.UUID;

public interface CourseService {
    UUID createCourse(Course course);
}
