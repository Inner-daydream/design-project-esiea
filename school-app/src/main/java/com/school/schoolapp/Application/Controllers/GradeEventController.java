// package com.school.schoolapp.Application.Controllers;

// import com.school.schoolapp.Application.Requests.CreateGradeEventRequest;
// import com.school.schoolapp.Application.response.CreateGradeEventResponse;
// import com.school.schoolapp.domain.Interfaces.IEvent;
// import com.school.schoolapp.domain.Interfaces.IPerson;
// import com.school.schoolapp.domain.implementations.GradeEvent;
// import com.school.schoolapp.domain.services.EventService;
// import com.school.schoolapp.domain.services.GradeEventService;
// import com.school.schoolapp.domain.services.PersonService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/gradeEvent")
// public class GradeEventController {
//     private final PersonService personService;

//     private final EventService eventService;
//     private final GradeEventService gradeEventService;


//     @Autowired
//     public GradeEventController(PersonService personService, EventService eventService, GradeEventService gradeEventService) {
//         this.personService = personService;
//         this.eventService = eventService;
//         this.gradeEventService = gradeEventService;
//     }
//     @PostMapping("/create")
//     public CreateGradeEventResponse createConference(@RequestBody CreateGradeEventRequest request){
//         IPerson person  = personService.getPerson(request.getPersonId());
//         IEvent event = eventService.getEvent(request.getEventId());
//         var res = gradeEventService.createGradeEvent(new GradeEvent(
//             event,
//                 person
//         ));
//         return null;
//     }



// }
