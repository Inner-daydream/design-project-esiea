package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.abstractions.Person;

import java.util.UUID;

public interface PersonService {

    UUID createPerson(Person person);
}
