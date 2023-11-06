package com.school.schoolapp.infrastructure.repository.postgre.Conference;

import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.ports.ConferenceRepository;
import com.school.schoolapp.infrastructure.entities.ClassroomEntity;
import com.school.schoolapp.infrastructure.entities.ConferenceEntity;
import com.school.schoolapp.infrastructure.entities.EventEntity;
import com.school.schoolapp.infrastructure.entities.PersonEntity;

import com.school.schoolapp.infrastructure.repository.postgre.event.PostgreEventDataRepository;
import com.school.schoolapp.infrastructure.repository.postgre.classroom.PostgreClassroomDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<List<Conference>> findAll() {
        List<ConferenceEntity> conferenceEntities = this.postgreConferenceDataRepository.findAll();
        if (conferenceEntities.size() > 0) {
            List<Conference> conferences = new java.util.ArrayList<Conference>();
            for (ConferenceEntity conferenceEntity : conferenceEntities) {
                EventEntity eventEntity = conferenceEntity.getEvent();
                ClassroomEntity classroomEntity = eventEntity.getClassroom();
                PersonEntity speakerEntity = conferenceEntity.getSpeaker();
                List<Student> attendees = new java.util.ArrayList<Student>();
                for (PersonEntity personEntity : eventEntity.getAttendees()) {
                    attendees.add(new Student(personEntity.getName(), personEntity.getPhoneNumber(), personEntity.getAddress()));
                }
                Conference conference = new Conference(
                        eventEntity.getName(),
                        new Classroom(
                                classroomEntity.getName(),
                                classroomEntity.getBuildingName(),
                                classroomEntity.getCapacity()
    
                        ),
                        eventEntity.getStartDate(),
                        eventEntity.getEndDate(),
                        attendees,
                        eventEntity.getCapacity(),
                        eventEntity.isOptional(),
                        new Person(speakerEntity.getName(), speakerEntity.getPhoneNumber(), speakerEntity.getAddress())
                );
                conferences.add(conference);
            }
            return Optional.of(conferences);
        }
        return Optional.empty();
    }
}
