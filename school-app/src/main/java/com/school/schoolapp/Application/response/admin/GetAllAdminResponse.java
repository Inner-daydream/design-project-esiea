package com.school.schoolapp.Application.response.admin;

import com.school.schoolapp.domain.implementations.Admin;
import java.util.List;
public class GetAllAdminResponse {
    private List<Admin> admins;

    public GetAllAdminResponse(List<Admin> admins) {
        this.admins = admins;
    }
    public List<Admin> getAdmins() {
        return this.admins;
    }
}
