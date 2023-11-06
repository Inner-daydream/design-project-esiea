package com.school.schoolapp.Application.response.teacher;

import java.util.UUID;

public class CreateTeacherResponse {
    private final UUID id;

    public CreateTeacherResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
}
