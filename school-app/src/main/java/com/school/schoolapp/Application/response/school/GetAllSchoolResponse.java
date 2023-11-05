package com.school.schoolapp.Application.response.school;

import com.school.schoolapp.domain.implementations.School;
import java.util.List;
public class GetAllSchoolResponse {
    
    private List<School> schools;

    public GetAllSchoolResponse(List<School> schools) {
        this.schools = schools;
    }
    public List<School> getSchools() {
        return this.schools;
    }
}
