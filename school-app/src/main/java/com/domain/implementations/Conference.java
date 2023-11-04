package com.domain.implementations;

import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;
import com.domain.abstractions.Person;
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
