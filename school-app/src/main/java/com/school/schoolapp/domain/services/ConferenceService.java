package com.school.schoolapp.domain.services;

import java.util.UUID;
import com.school.schoolapp.domain.implementations.Conference;
public interface ConferenceService {
    UUID createConference(Conference conference);
}
