package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Services.SchoolService;
import com.school.schoolapp.domain.implementations.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/school")
public class SchoolController {

    private final SchoolService schooltest;
    @Autowired
    public SchoolController(SchoolService schooltest) {
        this.schooltest = schooltest;
    }


    @GetMapping
    public List<School> getSchools(){
        return schooltest.getSchools();
    }
}
