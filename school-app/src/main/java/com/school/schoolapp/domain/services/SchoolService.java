package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.School;
import java.util.UUID;
import java.util.List;

public interface SchoolService {
    UUID createSchool(School school);
    void updateSchool(School school);
    List<School> getAllSchool();
}
