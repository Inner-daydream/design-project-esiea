package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.ports.StudentRepository;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import com.school.schoolapp.infrastructure.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
                    UUID.fromString(studentEntity.get().getSchoolID()), 
                    UUID.fromString(studentEntity.get().getID()),
                    studentEntity.get().getLunchCredit()
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

    @Override
    public void update(Student student) {
        StudentEntity studentEntity = new StudentEntity(student);
        PersonEntity personEntity = new PersonEntity(student);
        this.personRepository.save(personEntity);
        this.postgreStudentDataRepository.save(studentEntity);
    }

    @Override
    public Optional<List<Student>> findAllById(List<String> ids) {
        List<StudentEntity> studentEntity = this.postgreStudentDataRepository.findAllById(ids); 
        if(studentEntity.size() > 0) {
            List<Student> students = studentEntity.stream().map(student -> {
                return new Student(
                    student.getName(),
                    student.getPhoneNumber(),
                    student.getAddress(),
                    UUID.fromString(student.getSchoolID()),
                    UUID.fromString(student.getID()),
                    student.getLunchCredit()
                );
            }).toList();
            return Optional.of(students);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Student>> findAll() {
        List<StudentEntity> studentEntity = this.postgreStudentDataRepository.findAll(); 
        if(studentEntity.size() > 0) {
            List<Student> students = studentEntity.stream().map(student -> {
                return new Student(
                    student.getName(),
                    student.getPhoneNumber(),
                    student.getAddress(),
                    UUID.fromString(student.getSchoolID()),
                    UUID.fromString(student.getID()),
                    student.getLunchCredit()
                );
            }).toList();
            return Optional.of(students);
        }
        return Optional.empty();
    }
}
