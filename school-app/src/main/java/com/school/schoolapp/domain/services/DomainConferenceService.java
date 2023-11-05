package com.school.schoolapp.domain.services;
import com.school.schoolapp.domain.ports.ConferenceRepository;
import com.school.schoolapp.domain.implementations.Conference;
import java.util.UUID;

public class DomainConferenceService implements ConferenceService{
    private final ConferenceRepository conferenceRepository;
    public DomainConferenceService(ConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
    }
    @Override
    public UUID createConference(Conference conference) {
        conferenceRepository.save(conference);
        return conference.getId();
    }

    
}
