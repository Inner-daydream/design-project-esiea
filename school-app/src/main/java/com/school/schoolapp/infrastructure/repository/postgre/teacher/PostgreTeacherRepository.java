package com.school.schoolapp.infrastructure.repository.postgre.teacher;

import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.TeacherRepository;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import com.school.schoolapp.infrastructure.entities.TeacherEntity;
import com.school.schoolapp.infrastructure.repository.postgre.PostgrePersonDataRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PostgreTeacherRepository implements TeacherRepository {
    private final PostgreTeacherDataRepository postgreTeacherDataRepository;

    private final PostgrePersonDataRepository personRepository;

    public PostgreTeacherRepository(
            PostgreTeacherDataRepository postgreTeacherDataRepository,
            PostgrePersonDataRepository personRepository
    ) {
        this.postgreTeacherDataRepository = postgreTeacherDataRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Teacher> findById(String id) {
        Optional<TeacherEntity> teacherEntity = this.postgreTeacherDataRepository.findById(id);
        if (teacherEntity.isPresent() ) {
            Teacher teacher = new Teacher(
                    teacherEntity.get().getName(),
                    teacherEntity.get().getPhoneNumber(),
                    teacherEntity.get().getAddress(),
                    UUID.fromString(teacherEntity.get().getSchoolID()),
                    UUID.fromString(teacherEntity.get().getID()),
                    teacherEntity.get().getSalary()

            );
            return Optional.of(teacher);
        }
        return Optional.empty();
    }

    @Override
    public void update(Teacher teacher) {
        TeacherEntity teacherEntity = new TeacherEntity(teacher);
        PersonEntity personEntity = new PersonEntity(teacher);
        this.personRepository.save(personEntity);
        this.postgreTeacherDataRepository.save(teacherEntity);
    }

    @Override
    public void save(Teacher teacher) {
        TeacherEntity teacherEntity = new TeacherEntity(teacher);
        PersonEntity personEntity = new PersonEntity(teacher);
        this.personRepository.save(personEntity);
        this.postgreTeacherDataRepository.save(teacherEntity);
    }

    @Override
    public Optional<List<Teacher>> findAll() {
        List<TeacherEntity> teacherEntities = this.postgreTeacherDataRepository.findAll();
        if (teacherEntities.size() > 0) {
            List<Teacher> teachers = teacherEntities.stream().map(teacherEntity -> new Teacher(
                    teacherEntity.getName(),
                    teacherEntity.getPhoneNumber(),
                    teacherEntity.getAddress(),
                    UUID.fromString(teacherEntity.getSchoolID()),
                    UUID.fromString(teacherEntity.getID()),
                    teacherEntity.getSalary()
            )).toList();
            return Optional.of(teachers);
        }
        return Optional.empty();
    }

    
}
