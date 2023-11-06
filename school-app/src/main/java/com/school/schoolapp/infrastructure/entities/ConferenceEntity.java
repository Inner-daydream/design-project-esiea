package com.school.schoolapp.infrastructure.entities;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Conference;

import jakarta.persistence.*;

@Entity
public class ConferenceEntity {
    @Id
    private String ID;
    @OneToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "speaker_id")
    private PersonEntity speaker;


    public ConferenceEntity() {
    }
    
    public ConferenceEntity(Conference conference) {
        this.ID = conference.getId().toString();
        this.event = new EventEntity(conference);
        this.speaker = new PersonEntity(conference.getSpeaker());
    }
    public EventEntity getEvent() {
        return this.event;
    }

    public PersonEntity getSpeaker() {
        return this.speaker;
    }
}
