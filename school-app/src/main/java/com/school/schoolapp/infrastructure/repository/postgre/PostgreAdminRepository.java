package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Admin;
import com.school.schoolapp.domain.implementations.School;
import com.school.schoolapp.domain.ports.AdminRepository;
import com.school.schoolapp.infrastructure.entities.AdminEntity;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import com.school.schoolapp.infrastructure.entities.SchoolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostgreAdminRepository implements AdminRepository {
    private final String ADMIN_ROLE = "admin";
    private final PostgreAdminDataRepository postgreAdminDataRepository;
    private final PostgreSchoolDataRepository postgreSchoolRepository;
    private final PostgrePersonDataRepository personRepository;

    @Autowired
    public PostgreAdminRepository(
            PostgreAdminDataRepository postgreAdminDataRepository,
            PostgreSchoolDataRepository postgreSchoolRepository,
            PostgrePersonDataRepository personRepository
    ) {
        this.postgreAdminDataRepository = postgreAdminDataRepository;
        this.postgreSchoolRepository = postgreSchoolRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Admin> findById(String id) {
        Optional<AdminEntity> adminEntity = this.postgreAdminDataRepository.findById(id);

        if (adminEntity.isPresent() ) {
            Optional<SchoolEntity> schoolEntity = this.postgreSchoolRepository.findById(adminEntity.get().getSchoolID());
            if(!schoolEntity.isPresent()) return Optional.empty();
            Admin admin = new Admin(
                    adminEntity.get().getName(),
                    adminEntity.get().getPhoneNumber(),
                    adminEntity.get().getAddress(),
                    new School(
                            schoolEntity.get().getName(),
                            schoolEntity.get().getAddress(),
                            schoolEntity.get().getPhoneNumber()
                    ),
                    adminEntity.get().getSalary()
            );
            return Optional.of(admin);
        }
        return Optional.empty();
    }

    @Override
    public void save(Admin admin) {
        AdminEntity adminEntity = new AdminEntity(admin);
        PersonEntity personEntity = new PersonEntity(admin);
        this.personRepository.save(personEntity);
        this.postgreAdminDataRepository.save(adminEntity);
    }
}
