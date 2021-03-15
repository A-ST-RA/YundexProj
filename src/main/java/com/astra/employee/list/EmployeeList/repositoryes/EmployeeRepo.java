package com.astra.employee.list.EmployeeList.repositoryes;

import com.astra.employee.list.EmployeeList.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
