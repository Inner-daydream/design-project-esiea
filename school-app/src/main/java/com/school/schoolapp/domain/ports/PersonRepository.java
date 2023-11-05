package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.abstractions.Person;

public interface PersonRepository {
    void save(Person person);
}
