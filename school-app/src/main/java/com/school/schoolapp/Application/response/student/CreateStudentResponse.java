package com.school.schoolapp.Application.response.student;

import java.util.UUID;

public class CreateStudentResponse {
    private final UUID id;

    public CreateStudentResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
}
