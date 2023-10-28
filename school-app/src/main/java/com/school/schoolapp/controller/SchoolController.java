package com.school.schoolapp.controller;

import com.school.schoolapp.entity.School;
import com.school.schoolapp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(path="api/v1/school")
    public List<School> getSchools(){
        return schoolService.getSchools();
    }
}
