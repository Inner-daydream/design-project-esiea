package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.ports.ConferenceRepository;
import com.school.schoolapp.infrastructure.entities.ConferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostgreConferenceRepository implements ConferenceRepository {

    private final PostgreConferenceDataRepository postgreConferenceDataRepository;
    @Autowired
    public PostgreConferenceRepository(PostgreConferenceDataRepository postgreConferenceDataRepository) {
        this.postgreConferenceDataRepository = postgreConferenceDataRepository;
    }


    @Override
    public void save(Conference conference) {
        ConferenceEntity conferenceEntity = new ConferenceEntity(conference);
        this.postgreConferenceDataRepository.save(conferenceEntity);
    }
}
