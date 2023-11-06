package com.school.schoolapp.Application.response.course;

import java.util.UUID;

public class CreateCourseResponse {
    private final UUID id;

    public CreateCourseResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
