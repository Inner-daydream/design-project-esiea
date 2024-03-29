package com.school.schoolapp.domain.services.program;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Person;

import java.util.UUID;

public interface PersonService {

    UUID createPerson(Person person);
    IPerson getPerson(String id);
}
