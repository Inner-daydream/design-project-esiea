# Use Cases



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
