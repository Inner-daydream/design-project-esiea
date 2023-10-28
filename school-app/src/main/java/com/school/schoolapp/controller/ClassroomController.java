package com.school.schoolapp.controller;

import com.school.schoolapp.entity.Classroom;
import com.school.schoolapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping(path="api/v1/classroom")
    public List<Classroom> getClassrooms(){
        return classroomService.getClassrooms();
    }
}
