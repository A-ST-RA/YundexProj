package com.astra.employee.list.EmployeeList.service;

import com.astra.employee.list.EmployeeList.model.Passport;
import com.astra.employee.list.EmployeeList.repositoryes.PassportRepo;
import org.springframework.stereotype.Service;

@Service
public class PassportService {
    private final PassportRepo passportRepo;

    public PassportService(PassportRepo passportRepo) {
        this.passportRepo = passportRepo;
    }

    public Passport save(String passportNumber) {
        return passportRepo.save(new Passport(passportNumber));
    }

    public Passport findById(Integer id) {
        return passportRepo.findById(id).get();
    }

    public Passport findByNumber(String passportNumber) {
        return passportRepo.findByNumber(passportNumber);
    }

    public void deleteById(Integer id) {
        passportRepo.deleteById(id);
    }

    public void updatePassport(Passport updatePassport) {
        passportRepo.save(updatePassport);
    }
}
