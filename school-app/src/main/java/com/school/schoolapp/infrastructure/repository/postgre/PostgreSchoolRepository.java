package com.school.schoolapp.infrastructure.repository.postgre;

import java.util.Optional;

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
    public Optional<School> findById(String id) {
        Optional<SchoolEntity> schoolEntity = this.postgreSchoolDataRepository.findById(id);
        if (schoolEntity.isPresent()) {
            School school = new School(schoolEntity.get().getName(), schoolEntity.get().getAddress(), schoolEntity.get().getPhoneNumber());
            return Optional.of(school);
        }
        return Optional.empty();
    }


    
}
