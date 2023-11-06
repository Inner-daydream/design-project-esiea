package com.school.schoolapp.infrastructure.repository.postgre.school;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.school.schoolapp.domain.implementations.School;
import com.school.schoolapp.domain.ports.SchoolRepository;
import com.school.schoolapp.infrastructure.entities.SchoolEntity;
@Component
public class PostgreSchoolRepository implements SchoolRepository {
    
    private final PostgreSchoolDataRepository postgreSchoolDataRepository;
    @Autowired
    public PostgreSchoolRepository(PostgreSchoolDataRepository postgreSchoolDataRepository) {
        this.postgreSchoolDataRepository = postgreSchoolDataRepository;
    }

    @Override
    public void save(School school) {
        SchoolEntity schoolEntity = new SchoolEntity(school);
        this.postgreSchoolDataRepository.save(schoolEntity);
    }

    @Override
    public void update(School school) {
        SchoolEntity schoolEntity = new SchoolEntity(school);
        this.postgreSchoolDataRepository.save(schoolEntity);
    }

    @Override
    public Optional<School> findById(String id) {
        Optional<SchoolEntity> schoolEntity = this.postgreSchoolDataRepository.findById(id);
        if (schoolEntity.isPresent()) {
            School school = new School(schoolEntity.get().getName(), schoolEntity.get().getAddress(), schoolEntity.get().getPhoneNumber());
            return Optional.of(school);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<School>> findAll() {
        List<SchoolEntity> schoolEntities = this.postgreSchoolDataRepository.findAll();
        if (schoolEntities.size() > 0) {
            List<School> school = schoolEntities.stream().map(schoolEntity -> 
                new School(
                    schoolEntity.getName(),
                    schoolEntity.getAddress(), 
                    schoolEntity.getPhoneNumber(),
                    UUID.fromString(schoolEntity.getID())
                )).toList();
            return Optional.of(school);
        }
        return Optional.empty();
        
    }


    
}
