package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class Conference extends Event {
    @OneToOne
    private Person speaker;

    public Conference(IPerson speaker) {
        this.speaker = (Person) speaker;
    }

    public Person getSpeaker() {
        return speaker;
    }
}
