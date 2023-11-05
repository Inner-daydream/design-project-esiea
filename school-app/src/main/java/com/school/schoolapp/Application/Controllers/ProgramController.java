package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.Program.CreateProgramRequest;
import com.school.schoolapp.Application.Requests.Program.UpdateProgramRequest;
import com.school.schoolapp.Application.response.program.CreateProgramResponse;
import com.school.schoolapp.Application.response.program.GetAllProgramResponse;
import com.school.schoolapp.domain.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/program")
public class ProgramController {
    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService){
        this.programService = programService;
    }

    @PostMapping("/create")
    public CreateProgramResponse createProgram(@RequestBody CreateProgramRequest request){
        UUID id = programService.createProgram(request.getProgram());
        return new CreateProgramResponse(id);
    }

    @PutMapping("/update")
    public void updateProgram(@RequestBody UpdateProgramRequest request){
        programService.updateProgram(request.getProgram());
    }

    @GetMapping
    public GetAllProgramResponse getPrograms(){
        return new GetAllProgramResponse(programService.getAllPrograms());
    }

}
