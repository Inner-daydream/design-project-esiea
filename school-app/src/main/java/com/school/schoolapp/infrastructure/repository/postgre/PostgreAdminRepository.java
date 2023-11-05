package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.domain.implementations.Admin;
import com.school.schoolapp.domain.ports.AdminRepository;
import com.school.schoolapp.infrastructure.entities.AdminEntity;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PostgreAdminRepository implements AdminRepository {
    private final PostgreAdminDataRepository postgreAdminDataRepository;
    private final PostgrePersonDataRepository personRepository;

    @Autowired
    public PostgreAdminRepository(
            PostgreAdminDataRepository postgreAdminDataRepository,
            PostgrePersonDataRepository personRepository
    ) {
        this.postgreAdminDataRepository = postgreAdminDataRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Admin> findById(String id) {
        Optional<AdminEntity> adminEntity = this.postgreAdminDataRepository.findById(id);

        if (adminEntity.isPresent() ) {
            Admin admin = new Admin(
                    adminEntity.get().getName(),
                    adminEntity.get().getPhoneNumber(),
                    adminEntity.get().getAddress(),
                    adminEntity.get().getSalary(),
                    UUID.fromString(adminEntity.get().getSchoolID())
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

    @Override
    public void update(Admin admin) {
        AdminEntity adminEntity = new AdminEntity(admin);
        PersonEntity personEntity = new PersonEntity(admin);
        this.personRepository.save(personEntity);
        this.postgreAdminDataRepository.save(adminEntity);
    }
    public Optional<List<Admin>> findAll() {
        List<AdminEntity> adminEntities = this.postgreAdminDataRepository.findAll();
        if (adminEntities.size() > 0) {
            List<Admin> admins = adminEntities.stream().map(admin -> {
                return new Admin(
                        admin.getName(),
                        admin.getPhoneNumber(),
                        admin.getAddress(),
                        admin.getSalary(),
                        UUID.fromString(admin.getSchoolID())
                );
            }).toList();
            return Optional.of(admins);
        }
        return Optional.empty();
    }

}
