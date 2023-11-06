# design-project-esiea

## Use case Diagram

![image-20231106103944203](C:\Users\jacqu\AppData\Roaming\Typora\typora-user-images\image-20231106103944203.png)

## Use case description

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
|                | 2    | School staff enters teacher's contact and adress information. |
|                | 3    | School staff enters teacher's salary information.            |
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
|             | 2    | System administrator enters admin's contact and adress information. |
|             | 3    | System administrator enters admin's salary information |
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

| Use case (name)       | Create a Classroom                               |
| --------------------- | ------------------------------------------------ |
| Pre-conditions        | None                                             |
| Success end condition | Classroom is successfully created in the system. |
| Failed end condition  | Classroom creation fails.                        |
| Actor                 | School Staff                                     |
| Trigger               | School staff initiates classroom creation.       |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff enters classroom details, including name, grade level, and capacity. |
|             | 2   | School staff reviews and confirms the entered information.   |
|             | 3   | System creates the classroom, and a unique classroom ID is generated. |
| Extensions     | Step | Branching action |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the classroom ID, it notifies the school staff. |
|                | 3    | If the school staff chooses to cancel the classroom creation, the use case ends without creating the classroom. |
| Sub-variations | Step | Branching action |
|                | 1    | If the school staff decides to add additional information or features, they can do so before confirming. |
|                | 2    | If the school staff decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the school staff needs to change the assigned teacher, they can do so before confirming. |
| Performance    |      | The classroom creation process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever a new classroom needs to be created. |

### Create a school

| Use case (name)       | Create a School                               |
| --------------------- | --------------------------------------------- |
| Pre-conditions        | None                                          |
| Success end condition | School is successfully created in the system. |
| Failed end condition  | School creation fails.                        |
| Actor                 | Administrator                                 |
| Trigger               | Administrator initiates school creation.      |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | Administrator enters school information, including name, address, and contact details. |
|             | 2   | Administrator reviews and confirms the entered information.  |
|             | 3 | System registers the school, and a unique school ID is generated. |
| Extensions     | Step | Branching action |
|                | 1    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 2    | If the system encounters an error while generating the school ID, it notifies the administrator. |
|                | 3    | If the administrator chooses to cancel the school creation, the use case ends without creating the school. |
| Sub-variations | Step | Branching action |
|                | 1    | If the administrator decides to add additional information, they can do so before confirming. |
|                | 2    | If the administrator decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the administrator needs to update school staff information, they can edit it before confirming. |
| Performance    |      | The school creation process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever a new school needs to be created. |

### See the list of students

| Use case (name)       | See the List of Students                                     |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Students must be registered in the system.                   |
| Success end condition | The list of students is successfully displayed.              |
| Failed end condition  | The system encounters an error while retrieving the list of students. |
| Actor                 | School Staff (Administrator or Teacher) or student           |
| Trigger               | School staff or teacher or student initiates the request to view the list of students. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher or student accesses the system and selects the option to view the list of students. |
|             | 2    | The system retrieves the list of registered students and displays it to the user. |
|             | 3    | School staff or teacher or student can navigate and search the list to find specific students. |
| Extensions     | Step | Branching action |
|                | 1    | If the system encounters an error while retrieving the list of students, it displays an error message. |
| Sub-variations | Step | Branching action |
|                | 1    | School staff or teacher or student can filter, sort, or apply search criteria to refine the list of students as needed. |
| Performance    |      | The system should efficiently retrieve and display the list of students. |
| Frequency      |      | This use case can occur whenever there is a need to view the list of students in the system. |

### See the list of teachers

| Use case (name)       | See the List of Teachers                                     |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Teachers must be registered in the system.                   |
| Success end condition | The list of teachers is successfully displayed.              |
| Failed end condition  | The system encounters an error while retrieving the list of teachers. |
| Actor                 | School Staff (Administrator or Teacher) or student           |
| Trigger               | School staff or teacher or student initiates the request to view the list of teachers. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher or student accesses the system and selects the option to view the list of teachers. |
|             | 2    | The system retrieves the list of registered teachers and displays it to the user. |
|             | 3    | School staff or teacher or student can navigate and search the list to find specific teachers. |
| Extensions     | Step | Branching action |
|                | 1    | If the system encounters an error while retrieving the list of teachers, it displays an error message. |
| Sub-variations | Step | Branching action |
|                | 1    | School staff or teacher or student can filter, sort, or apply search criteria to refine the list of teachers as needed. |
| Performance    |      | The system should efficiently retrieve and display the list of teachers. |
| Frequency      |      | This use case can occur whenever there is a need to view the list of teachers in the system. |

### See the list of admins

| Use case (name)       | See the List of Admins                                       |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Admins must be registered in the system.                     |
| Success end condition | The list of admins is successfully displayed.                |
| Failed end condition  | The system encounters an error while retrieving the list of admins. |
| Actor                 | Administrator                                                |
| Trigger               | The administrator initiates the request to view the list of admins. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | The administrator accesses the system and selects the option to view the list of admins. |
|             | 2    | The system retrieves the list of registered admins and displays it to the administrator. |
|             | 3    | The administrator can navigate and search the list to find specific admins. |
| Extensions     | Step | Branching action |
|                | 1    | If the system encounters an error while retrieving the list of admins, it displays an error message. |
| Sub-variations | Step | Branching action |
|                | 1    | The administrator can filter, sort, or apply search criteria to refine the list of admins as needed. |
| Performance    |      | The system should efficiently retrieve and display the list of admins. |
| Frequency      |      | This use case can occur whenever there is a need to view the list of admins in the system. |

### See the list of classrooms

| Use case (name)       | See the List of Classrooms                                   |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Classrooms must be created and registered in the system.     |
| Success end condition | The list of classrooms is successfully displayed.            |
| Failed end condition  | The system encounters an error while retrieving the list of classrooms. |
| Actor                 | School Staff (Administrator or Teacher)                      |
| Trigger               | School staff or teacher initiates the request to view the list of classrooms. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher accesses the system and selects the option to view the list of classrooms. |
|             | 2    | The system retrieves the list of registered classrooms and displays it to the user. |
|             | 3    | School staff or teacher can navigate and search the list to find specific classrooms. |
| Extensions     | Step | Branching action |
|                | 1    | If the system encounters an error while retrieving the list of classrooms, it displays an error message. |
| Sub-variations | Step | Branching action |
|                | 1    | School staff or teacher can filter, sort, or apply search criteria to refine the list of classrooms as needed. |
| Performance    |      | The system should efficiently retrieve and display the list of classrooms. |
| Frequency      |      | This use case can occur whenever there is a need to view the list of classrooms in the system. |

### See the list of Schools

| Use case (name)       | See the List of Schools                                      |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Schools must be created and registered in the system.        |
| Success end condition | The list of schools is successfully displayed.               |
| Failed end condition  | The system encounters an error while retrieving the list of schools. |
| Actor                 | Administrator                                                |
| Trigger               | The administrator initiates the request to view the list of schools. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | The administrator accesses the system and selects the option to view the list of schools. |
|             | 2    | The system retrieves the list of registered schools and displays it to the administrator. |
|             | 3    | The administrator can navigate and search the list to find specific schools. |
| Extensions     | Step | Branching action |
|                | 1    | If the system encounters an error while retrieving the list of schools, it displays an error message. |
| Sub-variations | Step | Branching action |
|                | 1    | The administrator can filter, sort, or apply search criteria to refine the list of schools as needed. |
| Performance    |      | The system should efficiently retrieve and display the list of schools. |
| Frequency      |      | This use case can occur whenever there is a need to view the list of schools in the system. |

### Edit teacher information

| Use case (name)       | Edit Teacher Information                                     |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Teacher must be registered in the system.                    |
| Success end condition | Teacher's information is successfully updated in the system. |
| Failed end condition  | Teacher information update fails.                            |
| Actor                 | School Staff (Administrator or Teacher)                      |
| Trigger               | School staff or teacher initiates the update of teacher information. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher selects the teacher whose information needs to be updated. |
|             | 2    | School staff or teacher modifies the teacher's personal information, contact details, or professional details as needed. |
|             | 3    | School staff or teacher reviews and confirms the updated information. |
|             | 4    | System updates the teacher's information in the system.      |
| Extensions     | Step | Branching action |
|                | 1    | If the selected teacher is not found in the system, an error message is displayed. |
|                | 2    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 3    | If there is an error while updating the teacher's information, the system notifies the user. |
|                | 4    | If the school staff or teacher chooses to cancel the update, the use case ends without updating the teacher's information. |
| Sub-variations | Step | Branching action |
|                | 1    | If the school staff or teacher decides to add additional information or details, they can do so before confirming. |
|                | 2    | If the school staff or teacher decides to modify any entered information, they can make changes before confirming. |
| Performance    |      | The teacher information update process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever there is a need to update a teacher's information in the system. |

### Edit student information

| Use case (name)       | Edit Student Information                                     |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Student must be registered in the system.                    |
| Success end condition | Student's information is successfully updated in the system. |
| Failed end condition  | Student information update fails.                            |
| Actor                 | School Staff (Administrator or Teacher)                      |
| Trigger               | School staff or teacher initiates the update of student information. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher selects the student whose information needs to be updated. |
|             | 2    | School staff or teacher modifies the student's personal information, contact details, or academic details as needed. |
|             | 3    | School staff or teacher reviews and confirms the updated information. |
|             | 4    | System updates the student's information in the system.      |
| Extensions     | Step | Branching action |
|                | 1    | If the selected student is not found in the system, an error message is displayed. |
|                | 2    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 3    | If there is an error while updating the student's information, the system notifies the user. |
|                | 4    | If the school staff or teacher chooses to cancel the update, the use case ends without updating the student's information. |
| Sub-variations | Step | Branching action |
|                | 1    | If the school staff or teacher decides to add additional information or details, they can do so before confirming. |
|                | 2    | If the school staff or teacher decides to modify any entered information, they can make changes before confirming. |
| Performance    |      | The student information update process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever there is a need to update a student's information in the system. |

### Edit admin information

| Use case (name)       | Edit Admin Information                                       |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Admin must be registered in the system.                      |
| Success end condition | Admin's information is successfully updated in the system.   |
| Failed end condition  | Admin information update fails.                              |
| Actor                 | System Administrator                                         |
| Trigger               | System administrator initiates the update of admin information. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | System administrator selects the admin whose information needs to be updated. |
|             | 2    | System administrator modifies the admin's personal information and contact details as needed. |
|             | 3    | System administrator reviews and confirms the updated information. |
|             | 4    | System updates the admin's information in the system.        |
| Extensions     | Step | Branching action |
|                | 1    | If the selected admin is not found in the system, an error message is displayed. |
|                | 2    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 3    | If there is an error while updating the admin's information, the system notifies the user. |
|                | 4    | If the system administrator chooses to cancel the update, the use case ends without updating the admin's information. |
| Sub-variations | Step | Branching action |
|                | 1    | If the system administrator decides to add additional information or details, they can do so before confirming. |
|                | 2    | If the system administrator decides to modify any entered information, they can make changes before confirming. |
| Performance    |      | The admin information update process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever there is a need to update an admin's information in the system. |

### Edit classroom information

| Use case (name)       | Edit Classroom Information                                   |
| --------------------- | ------------------------------------------------------------ |
| Pre-conditions        | Classroom must be created and registered in the system.      |
| Success end condition | Classroom's information is successfully updated in the system. |
| Failed end condition  | Classroom information update fails.                          |
| Actor                 | School Staff (Administrator or Teacher)                      |
| Trigger               | School staff or teacher initiates the update of classroom information. |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | School staff or teacher selects the classroom whose information needs to be updated. |
|             | 2    | School staff or teacher modifies the classroom's details, including name, grade level, capacity, and teacher assignment. |
|             | 3    | School staff or teacher reviews and confirms the updated information. |
|             | 4    | System updates the classroom's information in the system.    |
| Extensions     | Step | Branching action |
|                | 1    | If the selected classroom is not found in the system, an error message is displayed. |
|                | 2    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 3    | If there is an error while updating the classroom's information, the system notifies the user. |
|                | 4    | If the school staff or teacher chooses to cancel the update, the use case ends without updating the classroom's information. |
| Sub-variations | Step | Branching action |
|                | 1    | If the school staff or teacher decides to add additional information or details, they can do so before confirming. |
|                | 2    | If the school staff or teacher decides to modify any entered information, they can make changes before confirming. |
|                | 3    | If the teacher assignment to the classroom needs to be changed, it can be updated before confirming. |
| Performance    |      | The classroom information update process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever there is a need to update a classroom's information in the system. |

### Edit school information

| Use case (name)       | Edit School Information                                     |
| --------------------- | ----------------------------------------------------------- |
| Pre-conditions        | School must be created and registered in the system.        |
| Success end condition | School's information is successfully updated in the system. |
| Failed end condition  | School information update fails.                            |
| Actor                 | Administrator                                               |
| Trigger               | Administrator initiates the update of school information.   |

| DESCRIPTION | Step | Action                                                       |
| ----------- | ---- | ------------------------------------------------------------ |
|             | 1    | Administrator selects the school whose information needs to be updated. |
|             | 2    | Administrator modifies the school's information, including name, address, contact details, and school settings. |
|             | 3    | Administrator reviews and confirms the updated information.  |
|             | 4    | System updates the school's information in the system.       |
| Extensions     | Step | Branching action |
|                | 1    | If the selected school is not found in the system, an error message is displayed. |
|                | 2    | If the entered information is incomplete or incorrect, the system displays an error message. |
|                | 3    | If there is an error while updating the school's information, the system notifies the administrator. |
|                | 4    | If the administrator chooses to cancel the update, the use case ends without updating the school's information. |
| Sub-variations | Step | Branching action |
|                | 1    | If the administrator decides to add additional information or details, they can do so before confirming. |
|                | 2    | If the administrator decides to modify any entered information, they can make changes before confirming. |
| Performance    |      | The school information update process should be completed efficiently. |
| Frequency      |      | This use case occurs whenever there is a need to update a school's information in the system. |



## Package Diagram

![image-20231106105759825](C:\Users\jacqu\AppData\Roaming\Typora\typora-user-images\image-20231106105759825.png)
