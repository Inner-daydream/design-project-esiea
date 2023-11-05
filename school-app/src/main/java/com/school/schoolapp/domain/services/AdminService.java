package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Admin;

import java.util.UUID;

import java.util.List;

public interface AdminService {
    UUID createAdmin(Admin admin);
    void updateAdmin(Admin admin);
    List<Admin> getAllAdmins();
}
