package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.School;
import java.util.UUID;
public interface SchoolService {
    UUID createSchool(School school);
    void updateSchool(School school);
}
