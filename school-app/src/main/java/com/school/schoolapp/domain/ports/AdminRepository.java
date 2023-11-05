package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Admin;

import java.util.Optional;

public interface AdminRepository {

    Optional<Admin> findById(String id);

    void save(Admin admin);
}
