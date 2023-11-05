package com.school.schoolapp.domain.services;
import com.school.schoolapp.domain.ports.SchoolRepository;
import com.school.schoolapp.domain.implementations.School;

import java.util.List;
import java.util.UUID;
public class DomainSchoolService implements SchoolService {
    private final SchoolRepository schoolRepository;
    public DomainSchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    @Override
    public UUID createSchool(School school) {
        schoolRepository.save(school);
        return school.getId();
    }

    @Override
    public void updateSchool(School school) {
        schoolRepository.update(school);
    }
    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll().get();
    }
}
