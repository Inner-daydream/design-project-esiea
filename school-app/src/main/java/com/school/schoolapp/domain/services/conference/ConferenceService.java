package com.school.schoolapp.domain.services.conference;

import java.util.UUID;
import com.school.schoolapp.domain.implementations.Conference;
import java.util.List;
public interface ConferenceService {
    UUID createConference(Conference conference);
    List<Conference> getAllConferences();
}
