package com.school.schoolapp.Application.response.school;

import com.school.schoolapp.domain.implementations.School;
public class GetSchoolResponse {
    
    private School school;

    public GetSchoolResponse(School school) {
        this.school = school;
    }
    public School getSchools() {
        return this.school;
    }
}
