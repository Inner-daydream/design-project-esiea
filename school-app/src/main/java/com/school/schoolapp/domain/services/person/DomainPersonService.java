package com.school.schoolapp.domain.services.person;

import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.ports.PersonRepository;
import com.school.schoolapp.domain.services.program.PersonService;

import java.util.UUID;

public class DomainPersonService implements PersonService {
    private final PersonRepository personRepository;

    public DomainPersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public UUID createPerson(Person person) {
        personRepository.save(person);
        return person.getId();
    }

    @Override
    public Person getPerson(String id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }
    
}
