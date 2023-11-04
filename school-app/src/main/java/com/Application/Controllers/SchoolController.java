package com.Application.Controllers;

import com.Application.Services.SchoolService;
import com.domain.implementations.School;
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
