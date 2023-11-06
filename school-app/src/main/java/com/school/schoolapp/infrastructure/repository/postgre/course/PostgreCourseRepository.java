package com.school.schoolapp.infrastructure.repository.postgre.course;

import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.CourseRepository;
import com.school.schoolapp.infrastructure.entities.CourseEntity;
import com.school.schoolapp.infrastructure.entities.EventEntity;
import com.school.schoolapp.infrastructure.repository.postgre.PostgreEventDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Course> getAll() {
        List<CourseEntity> res = this.postgreCourseDataRepository.findAll();
        return res.stream().map(courseEntity -> new Course(
                courseEntity.isExam(),
                new Teacher(
                        courseEntity.getTeacher().getName(),
                        courseEntity.getTeacher().getPhoneNumber(),
                        courseEntity.getTeacher().getAddress(),
                        UUID.fromString(courseEntity.getTeacher().getSchoolID()),
                        UUID.fromString(courseEntity.getTeacher().getId())
                ),
                courseEntity.getEvent().getName(),
                courseEntity.getEvent().getClassroom().toClassroom(),
                courseEntity.getEvent().getStartDate(),
                courseEntity.getEvent().getEndDate(),
                courseEntity.getEvent().getAttendees().stream().map(
                        personEntity -> new Student(
                                personEntity.getName(),
                                personEntity.getPhoneNumber(),
                                personEntity.getAddress(),
                                UUID.fromString(personEntity.getSchoolID()),
                                UUID.fromString(personEntity.getId()),
                                0
                        )
                ).toList(),
                courseEntity.getEvent().getCapacity(),
                courseEntity.getEvent().isOptional()
        )).toList();
    }
}
