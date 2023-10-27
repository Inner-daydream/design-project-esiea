package com.domain.implementations;

import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;

public class Conference extends Event {
    private IPerson speaker;

    public Conference(IPerson speaker) {
        this.speaker = speaker;
    }

    public IPerson getSpeaker() {
        return speaker;
    }
}
