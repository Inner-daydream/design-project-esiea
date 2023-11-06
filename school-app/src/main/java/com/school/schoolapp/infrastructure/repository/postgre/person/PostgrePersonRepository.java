package com.school.schoolapp.infrastructure.repository.postgre.person;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Teacher;
import com.school.schoolapp.domain.ports.PersonRepository;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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
    @Override
        // public Teacher(String name, String phoneNumber, String address, UUID schoolID, UUID id, int salary) {
    public Optional<Person> findById(String id) {
        Optional<PersonEntity> personEntity = this.postgrePersonDataRepository.findById(id);
        if(personEntity.isPresent()) {
            Teacher admin = new Teacher(
                    personEntity.get().getName(),
                    personEntity.get().getPhoneNumber(),
                    personEntity.get().getAddress(),
                    UUID.fromString(personEntity.get().getSchoolID()),
                    UUID.fromString(id)
            );
            return Optional.of(admin);
        }
        return Optional.empty();
    }
}
