package com.school.schoolapp.Application.Requests.Program;

import javax.validation.constraints.NotNull;
import java.util.List;

public class addProgramRequest {
    @NotNull
    private List<String> coursesIDs;

    public List<String> getCoursesIDs() {
        return coursesIDs;
    }
}
