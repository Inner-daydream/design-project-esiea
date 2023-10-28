package com.school.schoolapp.controller;

import com.domain.implementations.Student;
import com.school.schoolapp.entity.Admin;
import com.school.schoolapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    protected AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(path="api/v1/admin")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }
}
