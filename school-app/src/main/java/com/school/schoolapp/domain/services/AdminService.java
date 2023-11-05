package com.school.schoolapp.domain.services;

import com.school.schoolapp.domain.implementations.Admin;

import java.util.UUID;

public interface AdminService {
    UUID createAdmin(Admin admin);
}
