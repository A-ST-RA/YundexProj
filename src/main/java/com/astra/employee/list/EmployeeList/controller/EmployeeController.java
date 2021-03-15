package com.astra.employee.list.EmployeeList.controller;

import com.astra.employee.list.EmployeeList.model.Employee;
import com.astra.employee.list.EmployeeList.model.Passport;
import com.astra.employee.list.EmployeeList.model.Position;
import com.astra.employee.list.EmployeeList.service.EmployeeService;
import com.astra.employee.list.EmployeeList.service.PassportService;
import com.astra.employee.list.EmployeeList.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // www.mysite.com/employees/all
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final PassportService passportService;

    public EmployeeController(EmployeeService employeeService, PositionService positionService, PassportService passportService) {
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.passportService = passportService;
    }


    @GetMapping("/all")
    public String showAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "EmployeeTemplates/all-Employees";
    }


    // Update
    @GetMapping("/update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Integer id, Model model) {
        Employee updatedEmployee = employeeService.findById(id);
        List<Position> positions = positionService.findAll();

        model.addAttribute("employee", updatedEmployee);
        model.addAttribute("positions", positions);

        return "EmployeeTemplates/edit-Employee";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee) {
        employeeService.update(employee);

        return "redirect:/employees/all";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);

        return "redirect:/employees/all";
    }

    // Passport update
    @GetMapping("/passport-update/{id}")
    public String editPassportForm(@PathVariable("id") int id, Model model) {
        Passport updatePassport = passportService.findById(id);

        model.addAttribute("passport", updatePassport);

        return "EmployeeTemplates/passport-update-Employee";
    }

    @PostMapping("/passport-update")
    public String editPassport(Passport passport) {
        passportService.updatePassport(passport);

        return "redirect:/employees/all";
    }

    // Create
    @GetMapping("/create")
    public String createEmployeeForm(Employee employee, Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);

        return "EmployeeTemplates/create-Employee";
    }

    @PostMapping("/create")
    public String createEmployee(Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/all";
    }
}
