package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.CreateSchoolRequest;
import com.school.schoolapp.Application.response.CreateSchoolResponse;
import com.school.schoolapp.domain.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
