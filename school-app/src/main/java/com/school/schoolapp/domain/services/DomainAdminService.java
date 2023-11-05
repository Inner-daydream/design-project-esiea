package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Admin;
import com.school.schoolapp.domain.ports.AdminRepository;

import java.util.List;
import java.util.UUID;

public class DomainAdminService implements AdminService{
    private final AdminRepository adminRepository;

    public DomainAdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public UUID createAdmin(Admin admin) {
        adminRepository.save(admin);
        return admin.getId();
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.update(admin);
    }
    
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll().get();
    }
}
