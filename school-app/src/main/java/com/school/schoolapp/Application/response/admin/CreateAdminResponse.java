package com.school.schoolapp.Application.response.admin;

import java.util.UUID;

public class CreateAdminResponse {
    private final UUID id;

    public CreateAdminResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
}
