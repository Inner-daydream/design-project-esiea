package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Course;

public interface CourseRepository {
    void save(Course course);
}
