# design-project-esiea

## Use case

### Register a Student

| Use case (name)       | Register a Student                                |
| --------------------- | ------------------------------------------------- |
| Pre-conditions        | None                                              |
| Success end condition | Student is successfully registered in the system. |
| Failed end condition  | Student registration fails.                       |
| Actor                 | School Staff                                      |
| Trigger               | School staff initiates student registration.      |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff enters student's name.                          |
|                | 2    | School staff enters student's contact information.           |
|                | 3    | School staff enters student's adress information.            |
|                | 4    | School staff reviews and confirms the entered information.   |
|                | 5    | System registers the student, and a student ID is generated. |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the student ID, it notifies the school staff. |
|                | 3    | If the school staff chooses to cancel the registration, the use case ends without registering the student. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the school staff decides to add additional information, they can do so before confirming. |
|                | 2    | If the school staff decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the school staff needs to update guardian information, they can edit it before confirming. |
| Performance    |      | The registration process should be completed efficiently.    |
| Frequency      |      | This use case occurs whenever a new student needs to be registered. |

### Register a teacher

| Use case (name)       | Register a Teacher                                |
| --------------------- | ------------------------------------------------- |
| Pre-conditions        | None                                              |
| Success end condition | Teacher is successfully registered in the system. |
| Failed end condition  | Teacher registration fails.                       |
| Actor                 | School Staff                                      |
| Trigger               | School staff initiates teacher registration.      |

| DESCRIPTION    | Step | Action                                                       |
| -------------- | ---- | ------------------------------------------------------------ |
|                | 1    | School staff enters teacher's personal information.          |
|                | 2    | School staff enters teacher's contact information.           |
|                | 3    | School staff enters teacher's educational and professional details. |
|                | 4    | School staff reviews and confirms the entered information.   |
|                | 5    | System registers the teacher, and a unique teacher ID is generated. |
| Extensions     | Step | Branching action                                             |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the teacher ID, it notifies the school staff. |
|                | 3    | If the school staff chooses to cancel the registration, the use case ends without registering the teacher. |
| Sub-variations | Step | Branching action                                             |
|                | 1    | If the school staff decides to add additional information, they can do so before confirming. |
|                | 2    | If the school staff decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the school staff needs to update educational or professional details, they can edit them before confirming. |

### Register an admin

| Use case (name)       | Register an Admin                                  |
| --------------------- | -------------------------------------------------- |
| Pre-conditions        | None                                               |
| Success end condition | Admin is successfully registered in the system.    |
| Failed end condition  | Admin registration fails.                          |
| Actor                 | System Administrator                               |
| Trigger               | System administrator initiates admin registration. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | System administrator enters admin's personal information.    |
|             | 2    | System administrator enters admin's contact information.     |
|             | 3    | System administrator configures admin privileges and roles.  |
|             | 4    | System administrator reviews and confirms the entered information. |
|             | 5    | System registers the admin, and a unique admin ID is generated. |
| Extensions     | Step | Branching action |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the admin ID, it notifies the system administrator. |
|                | 3    | If the system administrator chooses to cancel the registration, the use case ends without registering the admin. |
| Sub-variations | Step | Branching action |
|                | 1    | If the system administrator decides to add additional information, they can do so before confirming. |
|                | 2    | If the system administrator decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the system administrator needs to adjust admin privileges and roles, they can edit them before confirming. |
| Performance    |      | The admin registration process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever a new admin needs to be registered. |

### Create a classroom

### Create a school

### Edit teacher information

### Edit student information

### Edit admin information

### Edit classroom information

### Edit school information



