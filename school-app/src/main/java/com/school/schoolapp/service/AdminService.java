package com.school.schoolapp.service;

import com.school.schoolapp.entity.Admin;
import com.school.schoolapp.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final IAdminRepository adminRepository;

    @Autowired
    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }
}
