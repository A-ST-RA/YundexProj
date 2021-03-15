package com.astra.employee.list.EmployeeList.service;

import com.astra.employee.list.EmployeeList.model.Employee;
import com.astra.employee.list.EmployeeList.model.Passport;
import com.astra.employee.list.EmployeeList.repositoryes.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final PassportService passportService;

    public EmployeeService(EmployeeRepo employeeRepo, PassportService passportService) {
        this.employeeRepo = employeeRepo;
        this.passportService = passportService;
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Integer id) {
        Employee findEmployee = employeeRepo.findById(id).get();
        String passportNumber = findEmployee.getPassport().getNumber();

        findEmployee.setPassportNumber(passportNumber);

        return findEmployee;
    }

    public Employee update(Employee employee) {
        employee.setPassport(
                passportService.findByNumber(employee.getPassportNumber()));
        return employeeRepo.save(employee);
    }

    public Employee save(Employee employee) {
        Passport passport = passportService.save(employee.getPassportNumber());
        employee.setPassport(passport);

        return employeeRepo.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
