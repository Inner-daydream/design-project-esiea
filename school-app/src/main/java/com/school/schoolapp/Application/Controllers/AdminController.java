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
    private final PersonService personService;

    @Autowired
    public AdminController(AdminService adminService, PersonService personService) {
        this.adminService = adminService;
        this.personService = personService;
    }

    @PostMapping("/create")
    public CreateAdminResponse createAdmin(@RequestBody CreateAdminRequest request){
        UUID id = adminService.createAdmin(request.getAdmin());
        return new CreateAdminResponse(id);
    }

}
