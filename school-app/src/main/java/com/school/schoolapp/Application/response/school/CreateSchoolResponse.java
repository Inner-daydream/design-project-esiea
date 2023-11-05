package com.school.schoolapp.Application.response.school;
import java.util.UUID;
public class CreateSchoolResponse {
    private final UUID id;
    public CreateSchoolResponse(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return this.id;
    }
}
