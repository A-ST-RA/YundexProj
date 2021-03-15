package com.astra.employee.list.EmployeeList.controller;

import com.astra.employee.list.EmployeeList.model.Position;
import com.astra.employee.list.EmployeeList.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);

        return "PositionTemplates/all-Positions";
    }

    // Update
    @GetMapping("/update/{id}")
    public String updatePositionForm(@PathVariable("id") int id, Model model) {
        Position updatePosition = positionService.findById(id);
        model.addAttribute("position", updatePosition);

        return "PositionTemplates/edit-Position";
    }

    @PostMapping("/update")
    public String updatePosition(Position position) {
        positionService.save(position);

        return "redirect:/positions/all";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deletePosition(@PathVariable("id") int id) {
        positionService.deleteById(id);

        return "redirect:/positions/all";
    }

    // Create
    @GetMapping("/create")
    public String createPositionForm(Position position) {
        return "PositionTemplates/create-Position";
    }

    @PostMapping("/create")
    public String createPosition(Position position) {
        positionService.save(position);

        return "redirect:/positions/all";
    }
}
