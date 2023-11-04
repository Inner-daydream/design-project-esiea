package com.Application.Services;

import com.domain.implementations.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class AdminService {
    //private final AdminRepository repository;

    public AdminService(/*AdminRepository repository*/) {
        //this.repository = repository;
    }
    public List<Admin> getAllAdmins(){
        //return repository.findAll();
        return List.of(null);
    }

    public void addAdmin(Admin admin){
        //repository.save(admin);
    }
    @Transactional
    public void createProgram(Long adminId, String programName){
        //Admin ad = repository.findById(adminId).orElseThrow();
        //ad.createProgram(programName);
    }
}
