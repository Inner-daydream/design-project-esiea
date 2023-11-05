package com.school.schoolapp.infrastructure.repository.postgre;

import com.school.schoolapp.infrastructure.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreAdminDataRepository extends JpaRepository<AdminEntity, String> {
}
