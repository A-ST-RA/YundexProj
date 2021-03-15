package com.astra.employee.list.EmployeeList.repositoryes;

import com.astra.employee.list.EmployeeList.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Integer> {
    Passport findByNumber(String number);
}
