package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Conference;
import java.util.List;
import java.util.Optional;
public interface ConferenceRepository {
    void save(Conference conference);
    Optional<List<Conference>> findAll();
} 