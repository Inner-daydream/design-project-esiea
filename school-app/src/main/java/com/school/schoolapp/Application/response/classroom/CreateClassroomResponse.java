package com.school.schoolapp.Application.response.classroom;

import java.util.UUID;

public class CreateClassroomResponse {
    private final UUID id;
    public CreateClassroomResponse(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return this.id;
    }
}
