package com.school.schoolapp.controller;

import com.school.schoolapp.entity.Teacher;
import com.school.schoolapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(path="api/v1/teacher")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }
}
