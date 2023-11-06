package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.Program.CreateProgramRequest;
import com.school.schoolapp.Application.Requests.Program.UpdateProgramRequest;
import com.school.schoolapp.Application.response.program.CreateProgramResponse;
import com.school.schoolapp.Application.response.program.GetAllProgramsResponse;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.services.course.CourseService;
import com.school.schoolapp.domain.services.program.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/program")
public class ProgramController {
    private final ProgramService programService;
    private final CourseService courseService;

    @Autowired
    public ProgramController(ProgramService programService, CourseService courseService){
        this.programService = programService;
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public CreateProgramResponse createProgram(@RequestBody CreateProgramRequest request){
        UUID id = programService.createProgram(request.getProgram());
        return new CreateProgramResponse(id);
    }

    @PutMapping("/update")
    public void updateProgram(@RequestBody UpdateProgramRequest request){
        List<Course>  events= courseService.getAll().stream().filter(course -> request.getEvents().contains(course.getId().toString())).toList();
        LinkedList<Event> events1 = new LinkedList<Event>();
        for (Course course : events) {
            events1.add(course);
        }
        programService.updateProgram(request.getProgram(events1));
    }
    /*@PostMapping("/add")
    public void addCourse(@RequestBody addProgramRequest request){

    }*/
    @GetMapping
    public GetAllProgramsResponse getPrograms(){
        return new GetAllProgramsResponse(programService.getAllPrograms());
    }

}
