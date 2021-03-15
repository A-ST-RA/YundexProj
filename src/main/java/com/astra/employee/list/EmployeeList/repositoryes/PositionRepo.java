package com.astra.employee.list.EmployeeList.repositoryes;

import com.astra.employee.list.EmployeeList.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {
}
