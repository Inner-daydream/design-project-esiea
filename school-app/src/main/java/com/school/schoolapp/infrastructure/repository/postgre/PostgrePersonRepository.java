package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Admin;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.PersonRepository;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostgrePersonRepository implements PersonRepository {
    private final PostgrePersonDataRepository postgrePersonDataRepository;

    @Autowired
    public PostgrePersonRepository(PostgrePersonDataRepository postgrePersonDataRepository) {
        this.postgrePersonDataRepository = postgrePersonDataRepository;
    }
    @Override
    public void save(Person person) {
        PersonEntity personEntity = new PersonEntity(person);
        this.postgrePersonDataRepository.save(personEntity);
    }
}