package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.ports.StudentRepository;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import com.school.schoolapp.infrastructure.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PostgreStudentRepository implements StudentRepository {
    private final PostgreStudentDataRepository postgreStudentDataRepository;
    private final PostgrePersonDataRepository personRepository;
    @Autowired
    public PostgreStudentRepository(
            PostgreStudentDataRepository postgreStudentDataRepository,
            PostgrePersonDataRepository personRepository
    ) {
        this.postgreStudentDataRepository = postgreStudentDataRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Student> findById(String id) {
        Optional<StudentEntity> studentEntity = this.postgreStudentDataRepository.findById(id);
        if(studentEntity.isPresent()) {
            Student student = new Student(
                    studentEntity.get().getName(),
                    studentEntity.get().getPhoneNumber(),
                    studentEntity.get().getAddress(),
                    studentEntity.get().getLunchCredit(),
                    UUID.fromString(studentEntity.get().getSchoolID())
            );
            return Optional.of(student);
        }
        return Optional.empty();
    }

    @Override
    public void save(Student student) {
        StudentEntity studentEntity = new StudentEntity(student);
        PersonEntity personEntity = new PersonEntity(student);
        this.personRepository.save(personEntity);
        this.postgreStudentDataRepository.save(studentEntity);
    }
}
