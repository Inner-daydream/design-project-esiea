package com.school.schoolapp.domain.ports;

import com.school.schoolapp.domain.implementations.Admin;

import java.util.Optional;
import java.util.List;

public interface AdminRepository {
    Optional<Admin> findById(String id);
    void save(Admin admin);
    void update(Admin admin);
    Optional<List<Admin>> findAll();

}
