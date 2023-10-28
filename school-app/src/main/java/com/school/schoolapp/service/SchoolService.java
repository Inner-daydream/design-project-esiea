package com.school.schoolapp.service;

import com.school.schoolapp.entity.School;
import com.school.schoolapp.repository.ISchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final ISchoolRepository schoolRepository;

    @Autowired
    public SchoolService(ISchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }
}
