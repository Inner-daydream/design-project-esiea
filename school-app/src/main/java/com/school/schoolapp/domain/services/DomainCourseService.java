package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.ports.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DomainCourseService implements  CourseService{

    private final CourseRepository repository;
    public DomainCourseService(CourseRepository repository) {
        this.repository = repository;
    }


    @Override
    public UUID createCourse(Course course) {
        repository.save(course);
        return course.getId();
    }
}