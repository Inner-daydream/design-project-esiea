
package com.school.schoolapp.config;

import com.school.schoolapp.entity.*;
import com.school.schoolapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner(IAdminRepository adminRepository,
            IClassroomRepository classroomRepository,
            IStudentRepository studentRepository,
            ITeacherRepository teacherRepository,
            ISchoolRepository schoolRepository) {
        return args -> {
            School school = schoolRepository.findByName("school1");
            if (school == null) {
                school = new School(
                        "school1",
                        "addr1",
                        "06571271");
                schoolRepository.save(school);
            }

            Admin adm1 = adminRepository.findByName("admin1");
            if (adm1 == null) {
                adm1 = new Admin(
                        "admin1",
                        "06571271",
                        "my addr",
                        school);
                adminRepository.save(adm1);
            }

            Admin adm2 = adminRepository.findByName("admin2");
            if (adm2 == null) {
                adm2 = new Admin(
                        "admin2",
                        "06571271",
                        "my addr",
                        school);
                adminRepository.save(adm2);
            }

            Classroom class1 = classroomRepository.findByName("class1");
            if (class1 == null) {
                class1 = new Classroom(
                        "class1",
                        "building1",
                        50,
                        school);
                classroomRepository.save(class1);
            }

            Classroom class2 = classroomRepository.findByName("class2");
            if (class2 == null) {
                class2 = new Classroom(
                        "class2",
                        "building2",
                        30,
                        school);
                classroomRepository.save(class2);
            }

            Teacher tea1 = teacherRepository.findByName("teacher1");
            if (tea1 == null) {
                tea1 = new Teacher(
                        "teacher1",
                        "06571271",
                        "my addr",
                        school,
                        1000);
                teacherRepository.save(tea1);
            }

            Teacher tea2 = teacherRepository.findByName("teacher2");
            if (tea2 == null) {
                tea2 = new Teacher(
                        "teacher2",
                        "06571271",
                        "my addr",
                        school,
                        2000);
                teacherRepository.save(tea2);
            }

            Student stu1 = studentRepository.findByName("student1");
            if (stu1 == null) {
                stu1 = new Student(
                        "student1",
                        "06571271",
                        "my addr",
                        school,
                        100);
                studentRepository.save(stu1);
            }

            Student stu2 = studentRepository.findByName("student2");
            if (stu2 == null) {
                stu2 = new Student(
                        "student2",
                        "06571271",
                        "my addr",
                        school,
                        200);
                studentRepository.save(stu2);
            }
        };
    };
}
