package com.school.schoolapp.Application.response;

import java.util.UUID;

public class CreateProgramResponse {
    private final UUID id;

    public CreateProgramResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
}
