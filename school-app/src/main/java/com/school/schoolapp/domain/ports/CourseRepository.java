package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Course;

import java.util.List;

public interface CourseRepository {
    void save(Course course);

    List<Course> getAll();
}
