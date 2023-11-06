# Use Cases

x ---title: School management system---​classDiagram    class IEvent {        <<Interface>>    }​    class IPerson {        <<Interface>>    }​    class Event {        <<Abstract>>        - name: String        - classroom: Classroom        - startDate: Date        - endDate: Date        - students: List~IPerson~        - capacity: int        - isOptional: bool        + isEventOptional(): bool        + getAttendees(): List~IPerson~        + getStartDate(): Date        + getEndDate(): Date        + getPlace(): Classroom        + getEventName(): String        + getEventCapacity(): int        + setAttendees(attendees: List~IPerson~): void        + setStartDate(startDate: Date): void        + setEndDate(endDate: Date): void        + setPlace(place: Classroom): void        + setEventName(name: String): void        + setCapacity(capacity: int): void    }​    class Person {        <<Abstract>>        - name: String        - phoneNumber: String        - address: String        - school: School        + getName(): String        + getPhoneNumber(): String        + getAddress(): String        + getEvents(): List~IEvent~        + setName(name: String): void        + setPhoneNumber(phoneNumber: String): void        + setAddress(address: String): void        + addEvent(event: Event): void        + removeEvent(eventIndex: int): void        + setEventList(eventList: List~IEvent~): void    }​    IEvent <|.. Event : implements    IPerson <|.. Person : implements​    class School {        - name: String        - address: String        - phoneNumber: String        - people: List~IPerson~        - programs: List~IProgram~        + getSchoolName(): String        + getSchoolAddress(): String        + getSchoolPhoneNumber(): String        + getEvent(eventName: String): IEvent    }​    class Course {        - isExam: boolean        - teacher: IPerson        + isExam(): boolean        + setIsExam(isExam: boolean): void    }​    class Conference {        - speakerName: String        + getSpeakerName(): String        + setSpeakerName(speakerName: String): void    }​    Person <|-- Student    Person <|-- Teacher    Person <|-- Admin​    Event <|-- Course    Event <|-- Conference​    class GradeEvent {        - event: IEvent        - person: IPerson        - grades: List~float~        + GradeEvent(event: IEvent, person: IPerson)        + addGrade(grade: float): void        + getAverage(): float    }​    class Student {        - grades: List~GradeEvent~        - lunchCredit: int        + getLunchCredit(): int        + setLunchCredit(lunchCredit: int): void        + applyToProgram(programName: String): void    }​    class IProgram {        <<Interface>>    }​    class Program {        - name: String        - events: List~IEvent~        + addEvent(event: IEvent): void        + getEvents(): List~IEvent~    }​    class Teacher {        - salary: int        + getSalary(): int        + setSalary(salary: int): int        + giveGrade(event: IEvent, student: IPerson, grade: float): void    }​    class Admin {        + assignToProgram(student: Student, programName: String): void        + registerAPerson(student: IPerson): void        + createProgram(programName: String): void        + addEventToProgram(event: IEvent, programName: String): void    }​    class Classroom {        - name: String        - buildingName: String        - capacity: int        + getName(): String        + getBuildingName(): String        + getCapacity(): int        + setCapacity(capacity: int): void        + setName(name: String): void        + setBuildingName(buildingName: String): void    }​mermaidSchool management system#mermaidChart0{font-family:sans-serif;font-size:16px;fill:#333;}#mermaidChart0 .error-icon{fill:#552222;}#mermaidChart0 .error-text{fill:#552222;stroke:#552222;}#mermaidChart0 .edge-thickness-normal{stroke-width:2px;}#mermaidChart0 .edge-thickness-thick{stroke-width:3.5px;}#mermaidChart0 .edge-pattern-solid{stroke-dasharray:0;}#mermaidChart0 .edge-pattern-dashed{stroke-dasharray:3;}#mermaidChart0 .edge-pattern-dotted{stroke-dasharray:2;}#mermaidChart0 .marker{fill:#333333;stroke:#333333;}#mermaidChart0 .marker.cross{stroke:#333333;}#mermaidChart0 svg{font-family:sans-serif;font-size:16px;}#mermaidChart0 g.classGroup text{fill:#9370DB;fill:#131300;stroke:none;font-family:sans-serif;font-size:10px;}#mermaidChart0 g.classGroup text .title{font-weight:bolder;}#mermaidChart0 .nodeLabel,#mermaidChart0 .edgeLabel{color:#131300;}#mermaidChart0 .edgeLabel .label rect{fill:#ECECFF;}#mermaidChart0 .label text{fill:#131300;}#mermaidChart0 .edgeLabel .label span{background:#ECECFF;}#mermaidChart0 .classTitle{font-weight:bolder;}#mermaidChart0 .node rect,#mermaidChart0 .node circle,#mermaidChart0 .node ellipse,#mermaidChart0 .node polygon,#mermaidChart0 .node path{fill:#ECECFF;stroke:#9370DB;stroke-width:1px;}#mermaidChart0 .divider{stroke:#9370DB;stroke-width:1;}#mermaidChart0 g.clickable{cursor:pointer;}#mermaidChart0 g.classGroup rect{fill:#ECECFF;stroke:#9370DB;}#mermaidChart0 g.classGroup line{stroke:#9370DB;stroke-width:1;}#mermaidChart0 .classLabel .box{stroke:none;stroke-width:0;fill:#ECECFF;opacity:0.5;}#mermaidChart0 .classLabel .label{fill:#9370DB;font-size:10px;}#mermaidChart0 .relation{stroke:#333333;stroke-width:1;fill:none;}#mermaidChart0 .dashed-line{stroke-dasharray:3;}#mermaidChart0 .dotted-line{stroke-dasharray:1 2;}#mermaidChart0 #compositionStart,#mermaidChart0 .composition{fill:#333333!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #compositionEnd,#mermaidChart0 .composition{fill:#333333!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #dependencyStart,#mermaidChart0 .dependency{fill:#333333!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #dependencyStart,#mermaidChart0 .dependency{fill:#333333!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #extensionStart,#mermaidChart0 .extension{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #extensionEnd,#mermaidChart0 .extension{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #aggregationStart,#mermaidChart0 .aggregation{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #aggregationEnd,#mermaidChart0 .aggregation{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #lollipopStart,#mermaidChart0 .lollipop{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 #lollipopEnd,#mermaidChart0 .lollipop{fill:#ECECFF!important;stroke:#333333!important;stroke-width:1;}#mermaidChart0 .edgeTerminals{font-size:11px;}#mermaidChart0 .classTitleText{text-anchor:middle;font-size:18px;fill:#333;}#mermaidChart0 :root{--mermaid-alt-font-family:sans-serif;}implementsimplements«Interface»IEvent«Interface»IPerson«Abstract»Event- name: String- classroom: Classroom- startDate: Date- endDate: Date- students: List<IPerson>- capacity: int- isOptional: bool+isEventOptional() : bool+getAttendees() : List<IPerson>+getStartDate() : Date+getEndDate() : Date+getPlace() : Classroom+getEventName() : String+getEventCapacity() : int+setAttendees(attendees: List<IPerson>) : void+setStartDate(startDate: Date) : void+setEndDate(endDate: Date) : void+setPlace(place: Classroom) : void+setEventName(name: String) : void+setCapacity(capacity: int) : void«Abstract»Person- name: String- phoneNumber: String- address: String- school: School+getName() : String+getPhoneNumber() : String+getAddress() : String+getEvents() : List<IEvent>+setName(name: String) : void+setPhoneNumber(phoneNumber: String) : void+setAddress(address: String) : void+addEvent(event: Event) : void+removeEvent(eventIndex: int) : void+setEventList(eventList: List<IEvent>) : voidSchool- name: String- address: String- phoneNumber: String- people: List<IPerson>- programs: List<IProgram>+getSchoolName() : String+getSchoolAddress() : String+getSchoolPhoneNumber() : String+getEvent(eventName: String) : IEventCourse- isExam: boolean- teacher: IPerson+isExam() : boolean+setIsExam(isExam: boolean) : voidConference- speakerName: String+getSpeakerName() : String+setSpeakerName(speakerName: String) : voidStudent- grades: List<GradeEvent>- lunchCredit: int+getLunchCredit() : int+setLunchCredit(lunchCredit: int) : void+applyToProgram(programName: String) : voidTeacher- salary: int+getSalary() : int+setSalary(salary: int) : int+giveGrade(event: IEvent, student: IPerson, grade: float) : voidAdmin+assignToProgram(student: Student, programName: String) : void+registerAPerson(student: IPerson) : void+createProgram(programName: String) : void+addEventToProgram(event: IEvent, programName: String) : voidGradeEvent- event: IEvent- person: IPerson- grades: List<float>+GradeEvent(event: IEvent, person: IPerson)+addGrade(grade: float) : void+getAverage() : float«Interface»IProgramProgram- name: String- events: List<IEvent>+addEvent(event: IEvent) : void+getEvents() : List<IEvent>Classroom- name: String- buildingName: String- capacity: int+getName() : String+getBuildingName() : String+getCapacity() : int+setCapacity(capacity: int) : void+setName(name: String) : void+setBuildingName(buildingName: String) : voidSchool management system

| Use case (name)      | Register a Student    |
| -------------------- | ---------------------- |
| Pre-conditions       | None                   |
| Success end condition | Student is successfully registered in the system. |
| Failed end condition | Student registration fails. |
| Actor                | School Staff           |
| Trigger              | School staff initiates student registration. |

| DESCRIPTION    | Step | Action           |
| -------------- | ---- | ---------------- |
|                | 1    | School staff enters student's personal information. |
|                | 2    | School staff enters student's contact information. |
|                | 3    | School staff enters student's guardian information. |
|                | 4    | School staff reviews and confirms the entered information. |
|                | 5    | System registers the student, and a student ID is generated. |
| Extensions     | Step | Branching action |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the student ID, it notifies the school staff. |
|                | 3    | If the school staff chooses to cancel the registration, the use case ends without registering the student. |
| Sub-variations | Step | Branching action |
|                | 1    | If the school staff decides to add additional information, they can do so before confirming. |
|                | 2    | If the school staff decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the school staff needs to update guardian information, they can edit it before confirming. |
| Performance    |      | The registration process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever a new student needs to be registered. |



| Use Case (name)       | Create a Program                                     |
| --------------------- | ---------------------------------------------------- |
| Pre-conditions        | None                                                 |
| Success end condition | Program is successfully created.                     |
| Failed end condition  | Program creation fails.                              |
| Actor                 | School Staff                                         |
| Trigger               | School staff initiates the program creation process. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff selects "Create Program" option.                |
|                | 2    | School staff enters program details (name, description, start date, end date, etc.). |
|                | 3    | School staff adds courses to the program (course name, description, duration, etc.). |
|                | 4    | School staff saves the program with its associated courses.  |
| Extensions     | Step | Branching action                                             |
|                | 1    | If any required information is missing, the system prompts school staff to complete it. |
|                | 2    | If the system encounters an error while saving, it notifies school staff and logs the error. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | School staff may need to specify additional program details such as prerequisites. |
|                | 2    | School staff can add or remove courses to/from the program.  |
| Performance    |      | The system should create the program with courses within a few seconds. |
| Frequency      |      | This use case is performed whenever a new program is to be created. |



| Use Case (name)       | Assign Student to a Program                            |
| --------------------- | ------------------------------------------------------ |
| Pre-conditions        | Student and program exist in the system.               |
| Success end condition | Student is successfully assigned to the program.       |
| Failed end condition  | Student assignment to the program fails.               |
| Actor                 | School Staff                                           |
| Trigger               | School staff initiates the student assignment process. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff selects "Assign Student to Program" option.     |
|                | 2    | School staff searches for the student by name or ID.         |
|                | 3    | School staff selects the program from the list of available programs. |
|                | 4    | School staff confirms the assignment.                        |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the student or program is not found in the system, school staff is notified. |
|                | 2    | If the system encounters an error during assignment, it notifies school staff and logs the error. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | School staff may need to specify additional details related to the assignment, such as start date. |
|                | 2    | School staff can modify or cancel the assignment before final confirmation. |
| Performance    |      | The system should assign the student to the program almost instantly. |
| Frequency      |      | This use case is performed whenever a student needs to be assigned to a program. |



| Use Case (name)       | Create a Course                                     |
| --------------------- | --------------------------------------------------- |
| Pre-conditions        | None                                                |
| Success end condition | Course is successfully created.                     |
| Failed end condition  | Course creation fails.                              |
| Actor                 | School Staff                                        |
| Trigger               | School staff initiates the course creation process. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff selects "Create Course" option.                 |
|                | 2    | School staff enters course details (course name, description, duration, etc.). |
|                | 3    | School staff specifies the course schedule and other relevant information. |
|                | 4    | School staff saves the course details in the system.         |
| Extensions     | Step | Branching action                                             |
|                | 1    | If any required information is missing, the system prompts school staff to complete it. |
|                | 2    | If the system encounters an error while saving, it notifies school staff and logs the error. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | School staff may need to specify additional course details, such as prerequisites or materials. |
|                | 2    | School staff can modify or cancel the course creation before final confirmation. |
| Performance    |      | The system should create the course within a few seconds.    |
| Frequency      |      | This use case is performed whenever a new course is to be created. |



| Use Case (name)       | Register a Teacher                                       |
| --------------------- | -------------------------------------------------------- |
| Pre-conditions        | None                                                     |
| Success end condition | Teacher is successfully registered in the system.        |
| Failed end condition  | Teacher registration fails.                              |
| Actor                 | School Staff                                             |
| Trigger               | School staff initiates the teacher registration process. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff selects "Register Teacher" option.              |
|                | 2    | School staff enters the teacher's personal details (name, contact information, etc.). |
|                | 3    | School staff assigns a unique teacher ID.                    |
|                | 4    | School staff specifies the subjects or courses the teacher is qualified to teach. |
|                | 5    | School staff saves the teacher's information in the system.  |
| Extensions     | Step | Branching action                                             |
|                | 1    | If any required information is missing, the system prompts school staff to complete it. |
|                | 2    | If the system encounters an error while saving, it notifies school staff and logs the error. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | School staff may need to provide additional teacher details, such as certifications or qualifications. |
|                | 2    | School staff can modify or cancel the teacher registration before final confirmation. |
| Performance    |      | The system should register the teacher within a few seconds. |
| Frequency      |      | This use case is performed whenever a new teacher needs to be registered. |



| Use Case (name)       | Assign Teacher to a Course                             |
| --------------------- | ------------------------------------------------------ |
| Pre-conditions        | Teacher and course exist in the system.                |
| Success end condition | Teacher is successfully assigned to the course.        |
| Failed end condition  | Teacher assignment to the course fails.                |
| Actor                 | School Staff                                           |
| Trigger               | School staff initiates the teacher assignment process. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff selects "Assign Teacher to Course" option.      |
|                | 2    | School staff searches for the teacher by name or ID.         |
|                | 3    | School staff selects the course from the list of available courses. |
|                | 4    | School staff confirms the teacher's assignment to the course. |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the teacher or course is not found in the system, school staff is notified. |
|                | 2    | If the system encounters an error during assignment, it notifies school staff and logs the error. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | School staff may need to specify additional details related to the assignment, such as the course schedule. |
|                | 2    | School staff can modify or cancel the teacher assignment before final confirmation. |
| Performance    |      | The system should assign the teacher to the course almost instantly. |
| Frequency      |      | This use case is performed whenever a teacher needs to be assigned to a course. |



| Use case (name)       | Assign Student to Course                        |
| --------------------- | ----------------------------------------------- |
| Pre-conditions        | Student is registered.                          |
| Success end condition | Student is successfully assigned to the course. |
| Failed end condition  | Student assignment to the course fails.         |
| Actor                 | School Administration                           |
| Trigger               | School administration initiates the assignment. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School administration initiates the assignment.              |
|                | 2    | Select the student to be assigned.                           |
|                | 3    | Choose the course to which the student will be assigned.     |
|                | 4    | Verify the student's eligibility for the selected course.    |
|                | 5    | Assign the student to the course.                            |
| Extensions     | Step | Branching action                                             |
|                | 1    | If no eligible courses are available for the student, notify the school administration and terminate the assignment. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If there are prerequisites for the selected course, ensure the student meets them. |
|                | 2    | If the student is already assigned to the course, inform the school administration and prevent duplicate assignment. |
|                | 3    | If the course is optionnal, verifiy that the student have applied to the course. |
| Performance    |      | System should handle student assignment to courses efficiently. |
| Frequency      |      | Student assignments occur as needed by the school administration. |



| Use case (name)       | Give Grade                                                   |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Student is enrolled in the course. Teacher is assigned to the course. |
| Success end condition | Student receives a grade for the course.                     |
| Failed end condition  | Grade assignment fails.                                      |
| Actor                 | Teacher                                                      |
| Trigger               | Teacher initiates the grade assignment.                      |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | Teacher initiates the grade assignment.                      |
|                | 2    | Select the student for whom the grade will be assigned.      |
|                | 3    | Enter the grade for the selected student in the chosen course. |
|                | 4    | Save the grade in the system.                                |
|                | 5    | Notify the teacher that the grade assignment is successful.  |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the selected student is not enrolled in the teacher course, notify the teacher and terminate the assignment. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the grade format is incorrect or doesn't meet the course requirements, prompt the teacher for correction. |
| Performance    |      | System should handle grade assignment efficiently.           |
| Frequency      |      | Grade assignments occur as needed by the teacher.            |



| Use case (name)       | Check Attendance                                             |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Teacher is assigned to the course.                           |
| Success end condition | Attendance is recorded for the course.                       |
| Failed end condition  | Attendance recording fails.                                  |
| Actor                 | Teacher                                                      |
| Trigger               | Teacher initiates the attendance check at the end of the course. |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | Teacher initiates the attendance check at the end of the course. |
|                | 2    | Access the list of students enrolled in the course.          |
|                | 3    | For each student, mark their attendance (e.g., present or absent). |
|                | 4    | Verify the accuracy of the recorded attendance.              |
|                | 5    | Save the attendance records for the course.                  |
|                | 6    | Notify the teacher that attendance recording is successful.  |
| Extensions     | Step | Branching action                                             |
|                | 2    | If there's a system error during the attendance recording process, notify the teacher about the failure. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the attendance recording format is incorrect, prompt the teacher for correction. |
|                | 2    | If a student's name is not found in the application, notify the teacher and request verification. |
| Performance    |      | System should handle attendance recording efficiently.       |
| Frequency      |      | Attendance checks occur at the end of each course by the teacher. |



| Use case (name)       | Check Scheduled Events                                       |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Student or teacher is logged into the application.           |
| Success end condition | Scheduled events (courses) list are displayed to the user.   |
| Failed end condition  | Unable to display scheduled events.                          |
| Actor                 | Student or Teacher                                           |
| Trigger               | Student or teacher initiates the check for scheduled events. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | Student or teacher initiates the check for scheduled events. |
|             | 2    | Access the list of scheduled events (courses) for the user.  |
|             | 3    | Display the scheduled events to the user.                    |
| Extensions  | Step | Branching action                                             |
|             | 1    | If the user is not logged into the application, notify them and terminate the check. |
|             | 2    | If there's a system error while accessing scheduled events, notify the user about the failure. |
| Performance |      | System should efficiently display scheduled events for students and teachers. |
| Frequency   |      | Students and teachers can check their scheduled events as needed. |



| Use case (name)       | Apply to a Course                                       |
| --------------------- | ------------------------------------------------------- |
| Pre-conditions        | Student is registered and logged into the application.  |
| Success end condition | Student is successfully applied to the selected course. |
| Failed end condition  | Course application fails.                               |
| Actor                 | Student                                                 |
| Trigger               | Student initiates the application for a course.         |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | Student initiates the application for a course.              |
|                | 2    | Access the list of optional courses available for the student. |
|                | 3    | Select the course to which the student wants to apply.       |
|                | 4    | Apply the student to the selected course.                    |
|                | 5    | Notify the student that the course application is successful. |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the user is not logged into the application, notify the student and terminate the application. |
|                | 2    | If there's a system error during the course application process, notify the student about the failure. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the selected course has prerequisites, ensure the student meets them. |
|                | 2    | If the student is already applied to the selected course, inform the student and prevent duplicate application. |
| Performance    |      | System should handle course applications efficiently.        |
| Frequency      |      | Students can apply to optional courses as needed.            |



| Use case (name)       | Apply to a Program                                       |
| --------------------- | -------------------------------------------------------- |
| Pre-conditions        | Student is logged into the application.                  |
| Success end condition | Student is successfully applied to the selected program. |
| Failed end condition  | Program application fails.                               |
| Actor                 | Student                                                  |
| Trigger               | Student initiates the application for a program.         |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | Student initiates the application for a program.             |
|                | 2    | Access the list of available programs for the student.       |
|                | 3    | Select the program to which the student wants to apply.      |
|                | 4    | Verify the student's eligibility for the selected program.   |
|                | 5    | Apply the student to the selected program.                   |
|                | 6    | Notify the student that the program application is successful. |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the user is not logged into the application, notify the student and terminate the application. |
|                | 2    | If there's a system error during the program application process, notify the student about the failure. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the selected program has prerequisites, ensure the student meets them. |
|                | 2    | If the student is already applied to the selected program, inform the student and prevent duplicate application. |
|                | 3    | If the student's details are inconsistent with the program requirements, prompt the student for clarification. |
| Performance    |      | System should handle program applications efficiently.       |
| Frequency      |      | Students can apply to programs as needed.                    |
