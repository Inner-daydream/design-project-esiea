package com.school.schoolapp.Application.response.program;

import com.school.schoolapp.domain.implementations.Program;
import java.util.List;
public class GetAllProgramResponse {
    private List<Program> programs;

    public GetAllProgramResponse(List<Program> programs) {
        this.programs = programs;
    }
    public List<Program> getPrograms() {
        return this.programs;
    }
}
