package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.conference.CreateConferenceRequest;
import com.school.schoolapp.Application.response.conference.CreateConferenceResponse;
import com.school.schoolapp.Application.response.conference.GetAllConferencesResponse;
import com.school.schoolapp.domain.services.classroom.ClassroomService;
import com.school.schoolapp.domain.services.conference.ConferenceService;
import com.school.schoolapp.domain.services.program.PersonService;
import com.school.schoolapp.domain.services.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/conference")
public class ConferenceController {

    private final ConferenceService conferenceService;
    private final StudentService studentService;
    private final ClassroomService classroomService;
    private final PersonService personService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService, StudentService studentService, ClassroomService classroomService, PersonService personService) {
        this.conferenceService = conferenceService;
        this.studentService = studentService;
        this.classroomService = classroomService;
        this.personService = personService;
    }

    @PostMapping("/create")
    public CreateConferenceResponse createConference(@RequestBody CreateConferenceRequest request){
        UUID id = conferenceService.createConference(
                request.getConference(
                        this.studentService.getStudents(request.getStudentsIDs()),
                        this.personService.getPerson(request.getSpeakerID()),
                        this.classroomService.getClassroom(request.getClassroomID())
                )
        );
        return new CreateConferenceResponse(id);
    }
    @GetMapping
    public GetAllConferencesResponse getConference(){
        return new GetAllConferencesResponse(conferenceService.getAllConferences());
    }
    

}
