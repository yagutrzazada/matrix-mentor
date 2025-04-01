package org.example.matrixmentor.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.matrixmentor.model.EmployeeDto;
import org.example.matrixmentor.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeContorller {
    public final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
        System.out.println(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployee(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);

    }

    @GetMapping
    public List<EmployeeDto> findEmployees() {
        return employeeService.findEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
    }

}
