package com.school.schoolapp.domain.ports;

import java.util.Optional;

import com.school.schoolapp.domain.abstractions.Person;

public interface PersonRepository {
    void save(Person person);
    Optional<Person> findById(String id);
}
