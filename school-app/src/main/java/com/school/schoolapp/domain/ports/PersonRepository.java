package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.abstractions.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {
    void save(Person person);
}
