package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.school.CreateSchoolRequest;
import com.school.schoolapp.Application.Requests.school.UpdateSchoolRequest;
import com.school.schoolapp.Application.response.school.CreateSchoolResponse;
import com.school.schoolapp.Application.response.school.GetAllSchoolResponse;
import com.school.schoolapp.domain.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
    private final SchoolService school;
    
    @Autowired
    public SchoolController(SchoolService school) {
        this.school = school;
    }
    @PostMapping("/create")
    public CreateSchoolResponse createSchool(@RequestBody CreateSchoolRequest request){
        UUID id = school.createSchool(request.getSchool());
        return new CreateSchoolResponse(id);
    }
    @GetMapping
    public GetAllSchoolResponse getSchools(){
        return new GetAllSchoolResponse(school.getAllSchool());
    }
    

    @PutMapping("/update")
    public void updateSchool(@RequestBody UpdateSchoolRequest request){
        school.updateSchool(request.getSchool());
    }

}
