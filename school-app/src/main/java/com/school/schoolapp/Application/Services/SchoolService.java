package com.school.schoolapp.Application.Services;

import com.school.schoolapp.domain.implementations.School;
import com.school.schoolapp.persistance.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class SchoolService {
    private final SchoolRepository repository;
    @Autowired
    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    public List<School> getSchools(){
        //return List.of(new School("name", "aa", "aa"));
        return repository.findAll();
    }
    public School getSchoolById(Long id){
        return repository.findById(id).orElseThrow();
    }

}
