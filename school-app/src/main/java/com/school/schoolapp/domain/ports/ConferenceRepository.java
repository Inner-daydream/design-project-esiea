package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Conference;
public interface ConferenceRepository {
    void save(Conference conference);
} 