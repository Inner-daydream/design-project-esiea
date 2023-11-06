package com.school.schoolapp.domain.services.course;

import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.ports.CourseRepository;
import com.school.schoolapp.domain.services.course.CourseService;

import java.util.List;
import java.util.UUID;

public class DomainCourseService implements CourseService {

    private final CourseRepository repository;
    public DomainCourseService(CourseRepository repository) {
        this.repository = repository;
    }


    @Override
    public UUID createCourse(Course course) {
        repository.save(course);
        return course.getId();
    }

    @Override
    public List<Course> getAll() {
        return repository.getAll();
    }
}
