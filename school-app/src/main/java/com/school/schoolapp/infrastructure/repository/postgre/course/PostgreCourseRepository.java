package com.school.schoolapp.infrastructure.repository.postgre.course;

import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.ports.CourseRepository;
import com.school.schoolapp.infrastructure.entities.CourseEntity;
import com.school.schoolapp.infrastructure.entities.EventEntity;
import com.school.schoolapp.infrastructure.repository.postgre.PostgreEventDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostgreCourseRepository  implements CourseRepository {
    private final PostgreEventDataRepository postgreEventDataRepository;
    private final PostgreCourseDataRepository postgreCourseDataRepository;
    @Autowired
    public PostgreCourseRepository(PostgreEventDataRepository postgreEventDataRepository, PostgreCourseDataRepository postgreCourseDataRepository) {
        this.postgreEventDataRepository = postgreEventDataRepository;
        this.postgreCourseDataRepository = postgreCourseDataRepository;
    }

    @Override
    public void save(Course course) {
        EventEntity eventEntity = new EventEntity(course);
        CourseEntity courseEntity = new CourseEntity(course);

        this.postgreEventDataRepository.save(eventEntity);
        this.postgreCourseDataRepository.save(courseEntity);

    }
}
