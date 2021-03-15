package com.astra.employee.list.EmployeeList.service;

import com.astra.employee.list.EmployeeList.model.Position;
import com.astra.employee.list.EmployeeList.repositoryes.PositionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepo positionRepo;

    public PositionService(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll() {
        return positionRepo.findAll();
    }

    public Position findById(Integer id) {
        return positionRepo.findById(id).get();
    }

    public Position save(Position position) {
        return positionRepo.save(position);
    }

    public void deleteById(Integer id) {
        positionRepo.deleteById(id);
    }
}
