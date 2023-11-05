package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.CreateConferenceRequest;
import com.school.schoolapp.Application.response.CreateConferenceResponse;
import com.school.schoolapp.domain.services.ClassroomService;
import com.school.schoolapp.domain.services.ConferenceService;
import com.school.schoolapp.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/conference")
public class ConferenceController {

    private final ConferenceService conferenceService;
    private final PersonService personService;
    private final ClassroomService classroomService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService, PersonService personService, ClassroomService classroomService) {
        this.conferenceService = conferenceService;
        this.personService = personService;
        this.classroomService = classroomService;
    }

    @PostMapping("/create")
    public CreateConferenceResponse createConference(@RequestBody CreateConferenceRequest request){
        List<String> studentsIDS = request.getStudentsIDs();
        List<Student> students = new ArrayList<Student>();
        UUID id = conferenceService.createConference(request.getConference());
        return new CreateConferenceResponse(id);
    }

}
