package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.domain.implementations.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    //private final AdminService adminService;
    //private final SchoolService schoolService;
    //@Autowired
    //public AdminController(AdminService adminService, SchoolService schoolService) {
        //this.adminService = adminService;
        //this.schoolService = schoolService;
    //}
    @GetMapping("all")
    public List<Admin> getall(){
        return List.of(null);
    }
    @GetMapping("add")
    public List<Admin> add(
            @PathVariable("name") String name,
            @PathVariable("phone") String phone,
            @PathVariable("addr") String addr,
            @PathVariable("schoolId") Long id
    ){
        //School sc = schoolService.getSchoolById(id);
        //adminService.addAdmin(new Admin(name, phone, addr, sc));
        return List.of(null);
    }
    @GetMapping("program")
    public void createProgram(
            @PathVariable("adminId") Long adminId,
            @PathVariable("progname") String name){
        //adminService.createProgram(adminId, name);
    }
}
