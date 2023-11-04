package com.Application.Services;

import com.domain.implementations.School;
import com.infrastructure.persistance.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
