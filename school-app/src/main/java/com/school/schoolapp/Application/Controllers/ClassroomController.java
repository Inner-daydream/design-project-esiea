package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.classroom.CreateClassroomRequest;
import com.school.schoolapp.Application.Requests.classroom.UpdateClassroomRequest;
import com.school.schoolapp.Application.response.CreateClassroomResponse;
import com.school.schoolapp.domain.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {

    private final ClassroomService classroom;

    @Autowired
    public ClassroomController(ClassroomService classroom) {
        this.classroom = classroom;
    }

    @PostMapping("/create")
    public CreateClassroomResponse createClassroom(@RequestBody CreateClassroomRequest request){
        UUID id = classroom.createClassroom(request.getClassroom());
        return new CreateClassroomResponse(id);
    }

    @PutMapping("/update")
    public void updateClassroom(@RequestBody UpdateClassroomRequest request){
        classroom.updateClassroom(request.getClassroom());
    }
}
