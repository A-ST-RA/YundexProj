package com.astra.employee.list.EmployeeList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String mainPage() {
        return "HomeTemplates/mainPage";
    }
}
