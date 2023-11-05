package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.CreateProgramRequest;
import com.school.schoolapp.Application.response.CreateProgramResponse;
import com.school.schoolapp.domain.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/program")
public class ProgramController {
    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping("/create")
    public CreateProgramResponse createProgram(@RequestBody CreateProgramRequest request){
        UUID id = programService.createProgram(request.getProgram());
        return new CreateProgramResponse(id);
    }
}
