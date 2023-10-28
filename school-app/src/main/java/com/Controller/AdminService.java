package com.Controller;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminService {
    public List<Admin> getAdmin() {
        return List.of(
                new Admin(1L,"admin1","06571271", "my addr")
        );
    }
}
