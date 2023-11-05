package com.school.schoolapp.Application.response;

import java.util.UUID;

public class CreateGradeEventResponse {
    private final UUID id;

    public CreateGradeEventResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
