package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.CreateAdminRequest;
import com.school.schoolapp.Application.response.CreateAdminResponse;
import com.school.schoolapp.domain.services.AdminService;
import com.school.schoolapp.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public CreateAdminResponse createAdmin(@RequestBody CreateAdminRequest request){
        UUID id = adminService.createAdmin(request.getAdmin());
        return new CreateAdminResponse(id);
    }

}
