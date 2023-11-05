package com.school.schoolapp.domain.ports;

import java.util.Optional;
import com.school.schoolapp.domain.implementations.Conference;
public interface ConferenceRepository {
    void save(Conference conference);
    Optional<Conference> findById(String id);
} 