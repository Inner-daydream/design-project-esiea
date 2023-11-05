package com.school.schoolapp.Application.response;

import java.util.UUID;

public class CreateConferenceResponse {
    private final UUID id;
    public CreateConferenceResponse(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return this.id;
    }
}
