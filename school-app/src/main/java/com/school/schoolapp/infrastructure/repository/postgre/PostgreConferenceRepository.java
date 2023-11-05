package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.ports.ConferenceRepository;
import com.school.schoolapp.infrastructure.entities.ClassroomEntity;
import com.school.schoolapp.infrastructure.entities.ConferenceEntity;
import com.school.schoolapp.infrastructure.entities.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PostgreConferenceRepository implements ConferenceRepository {

    private final PostgreConferenceDataRepository postgreConferenceDataRepository;
    private final PostgreEventDataRepository postgreEventDataRepository;
    private final PostgreClassroomDataRepository postgreClassroomDataRepository;
    @Autowired
    public PostgreConferenceRepository(
            PostgreConferenceDataRepository postgreConferenceDataRepository,
            PostgreEventDataRepository postgreEventDataRepository,
            PostgreClassroomDataRepository postgreClassroomDataRepository
    ) {
        this.postgreConferenceDataRepository = postgreConferenceDataRepository;
        this.postgreEventDataRepository = postgreEventDataRepository;
        this.postgreClassroomDataRepository = postgreClassroomDataRepository;
    }

    @Override
    public void save(Conference conference) {
        ClassroomEntity classroomEntity = postgreClassroomDataRepository.findById(conference.getClassroom().getId().toString()).get();
        ConferenceEntity conferenceEntity = new ConferenceEntity(conference);

        EventEntity eventEntity = new EventEntity(conference);
        this.postgreEventDataRepository.save(eventEntity);
        this.postgreConferenceDataRepository.save(conferenceEntity);
    }
}
