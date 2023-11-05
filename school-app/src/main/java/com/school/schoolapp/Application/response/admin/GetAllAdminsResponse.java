package com.school.schoolapp.Application.response.admin;

import com.school.schoolapp.domain.implementations.Admin;
import java.util.List;
public class GetAllAdminsResponse {
    private List<Admin> admins;

    public GetAllAdminsResponse(List<Admin> admins) {
        this.admins = admins;
    }
    public List<Admin> getAdmins() {
        return this.admins;
    }
}
