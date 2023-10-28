package com.domain.implementations;

import com.domain.Interfaces.IClassroom;
import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;

import java.util.Date;
import java.util.List;

public class Conference extends Event {
    private IPerson speaker;

    public Conference(String id, String name, IClassroom classroom, Date startDate, Date endDate, List<IPerson> students, int capacity, boolean isOptional, IPerson speaker) {
        super(id, name, classroom, startDate, endDate, students, capacity, isOptional);
        this.speaker = speaker;
    }

    public IPerson getSpeaker() {
        return speaker;
    }
}
