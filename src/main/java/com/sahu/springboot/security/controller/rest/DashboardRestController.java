package com.sahu.springboot.security.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardRestController {

    @GetMapping("/user")
    public String userDashboard() {
        return "User Dashboard";
    }


    @GetMapping("/admin")
    public String adminDashboard() {
        return "Admin Dashboard";
    }

}
