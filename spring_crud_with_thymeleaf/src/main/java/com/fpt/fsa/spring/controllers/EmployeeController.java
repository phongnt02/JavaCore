package com.fpt.fsa.spring.controllers;

import com.fpt.fsa.spring.middleware.request.EmployeeRequest;
import com.fpt.fsa.spring.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@RequiredArgsConstructor
@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee-detail";
    }

    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeRequest());
        return "employee-form";
    }

    @PostMapping
    public String saveEmployee(@Valid @ModelAttribute EmployeeRequest employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
