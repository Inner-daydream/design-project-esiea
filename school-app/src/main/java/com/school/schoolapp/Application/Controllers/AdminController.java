package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.admin.CreateAdminRequest;
import com.school.schoolapp.Application.Requests.admin.UpdateAdminRequest;
import com.school.schoolapp.Application.response.admin.CreateAdminResponse;
import com.school.schoolapp.Application.response.admin.GetAllAdminResponse;
import com.school.schoolapp.domain.services.AdminService;
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
    @GetMapping("/get")
    public GetAllAdminResponse getAdmin(){
        return new GetAllAdminResponse(adminService.getAllAdmins());
    }

    @PutMapping("/update")
    public void updateAdmin(@RequestBody UpdateAdminRequest request){
        adminService.updateAdmin(request.getAdmin());
    }

}
