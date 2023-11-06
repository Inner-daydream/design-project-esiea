package com.school.schoolapp.infrastructure.repository.postgre.program;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.implementations.Program;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.ProgramRepository;
import com.school.schoolapp.infrastructure.entities.CourseEntity;
import com.school.schoolapp.infrastructure.entities.ProgramEntity;
import com.school.schoolapp.infrastructure.repository.postgre.course.PostgreCourseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class PostgreProgramRepository implements ProgramRepository {
    private final PostgreProgramDataRepository postgreProgramDataRepository;
    private final PostgreCourseDataRepository postgreCourseDataRepository;
    @Autowired
    public PostgreProgramRepository(PostgreProgramDataRepository postgreProgramDataRepository, PostgreCourseDataRepository postgreCourseDataRepository) {
        this.postgreProgramDataRepository = postgreProgramDataRepository;
        this.postgreCourseDataRepository = postgreCourseDataRepository;
    }

    @Override
    public Optional<Program> findById(String id) {
        Optional<ProgramEntity> programEntity = this.postgreProgramDataRepository.findById(id);
        if (programEntity.isPresent()) {
            Program program = new Program(
                    programEntity.get().getName()
            );
            return Optional.of(program);
        }
        return Optional.empty();
    }

    @Override
    public void save(Program program) {
        ProgramEntity programEntity = new ProgramEntity(program);
        this.postgreProgramDataRepository.save(programEntity);
    }

    @Override
    public void update(Program program) {
        ProgramEntity programEntity = new ProgramEntity(program);
        this.postgreProgramDataRepository.save(programEntity);
    }

    @Override
    public Optional<List<Program>> findAll() {
        List<ProgramEntity> programEntities = this.postgreProgramDataRepository.findAll();
        if (programEntities.size() > 0) {
            List<Program> program = programEntities.stream().map(programEntity -> {
                        return new Program(
                                programEntity.getName(),
                                programEntity.getEvents().stream().map(
                                        courseEntity -> {
                                            Optional<CourseEntity> course = postgreCourseDataRepository.findAll().stream().filter(item -> item.getId().equals(courseEntity.getId())).findFirst();
                                            if (!course.isPresent()) {
                                                return null;
                                            }
                                            return new Course(
                                                    course.get().isExam(),
                                                    course.get().getTeacher() == null ? null :
                                                            new Teacher(
                                                                    course.get().getTeacher().getName(),
                                                                    course.get().getTeacher().getPhoneNumber(),
                                                                    course.get().getTeacher().getAddress(),
                                                                    UUID.fromString(course.get().getTeacher().getSchoolID()),
                                                                    UUID.fromString(course.get().getTeacher().getId())
                                                            ),
                                                    course.get().getEvent() == null ? null : course.get().getEvent().getName(),
                                                    course.get().getEvent() == null ? null : course.get().getEvent().getClassroom().toClassroom(),
                                                    course.get().getEvent() == null ? null : course.get().getEvent().getStartDate(),
                                                    course.get().getEvent() == null ? null : course.get().getEvent().getEndDate(),
                                                    course.get().getEvent() == null ? null : course.get().getEvent().getAttendees().stream().map(
                                                            personEntity -> new Student(
                                                                    personEntity.getName(),
                                                                    personEntity.getPhoneNumber(),
                                                                    personEntity.getAddress(),
                                                                    UUID.fromString(personEntity.getSchoolID()),
                                                                    UUID.fromString(personEntity.getId()),
                                                                    0
                                                            )
                                                    ).toList(),
                                                    course.get().getEvent() == null ? 0 : course.get().getEvent().getCapacity(),
                                                    course.get().getEvent() == null ? false : course.get().getEvent().isOptional(),
                                                    UUID.fromString(courseEntity.getId())
                                            );
                                        }
                                ).map(course -> (Event) course).toList()
                        );
                    }
            ).toList();
            return Optional.of(program);
        }
        return Optional.empty();
    }
}
