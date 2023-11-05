package com.school.schoolapp.Application.response.conference;

import com.school.schoolapp.domain.implementations.Conference;
import java.util.List;
public class GetAllConferencesResponse {
    private List<Conference> conferences;

    public GetAllConferencesResponse(List<Conference> conferences) {
        this.conferences = conferences;
    }
    public List<Conference> getConferences() {
        return this.conferences;
    }
}
