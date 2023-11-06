package com.school.schoolapp.infrastructure.repository.postgre.person;

import com.school.schoolapp.infrastructure.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgrePersonDataRepository extends JpaRepository<PersonEntity, String> {

}
